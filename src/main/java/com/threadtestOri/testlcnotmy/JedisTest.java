package com.threadtestOri.testlcnotmy;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;


public class JedisTest {

    private JedisPool pool;
    private int port = 6379;


    @Before
    public void init() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        pool = new JedisPool(jedisPoolConfig, "127.0.0.1", port);
    }

    @Test
    public void testJedis() {
        //A single Jedis instance is not thread safe
        Jedis jedis = new Jedis("127.0.0.1", port);
        //选择db1，默认是db0
        jedis.select(1);

        //java应该符合规范，提高可读性以及防止key冲突，比如项目名：业务名：类名：id
        String key = "crm:user:info:id1";
        String value = "this is user id1 info";
        jedis.set(key, value);
        assertEquals(value, jedis.get(key));
        jedis.close();
    }


    @Test
    public void testString() {
        try (Jedis jedis = pool.getResource()) {
            //清空库
            jedis.flushDB();

            String key = "key";
            String value = "123";
            jedis.set(key, value);
            //删除key，如果key不存在，则忽略此条命令
            jedis.del(key);

            //setnx：set if not exists，当key不存在时设置并返回1，若key已存在则忽略此条命令并返回0
            assertEquals(Long.valueOf(1), jedis.setnx(key, value));
            assertEquals(Long.valueOf(0), jedis.setnx(key, value));
            assertEquals(value, jedis.get(key));

            //key 0
            //append：给指定的key追加值
            String appendStr = "bar";
            jedis.append(key, appendStr);
            assertEquals(value + appendStr, jedis.get(key));

            //多个键值对
            jedis.mset("key1", "value1", "key2", "value2");
            List<String> valueList = jedis.mget("key1", "key2");
            assertThat(valueList, contains("value1", "value2"));
        }
        //Close poll when closing your application:
        pool.close();
    }

    @Test
    public void testKey() throws InterruptedException {
        try (Jedis jedis = pool.getResource()) {
            //清空库
            jedis.flushDB();
            String key = "key";
            String value = "abc";
            jedis.set(key, value);
            //判断库是否存在
            assertTrue(jedis.exists(key));

            //获取所有的key
            Set<String> keys = jedis.keys("*");
            assertThat(keys, contains(key));

            //查看key所存储的值类型
            assertEquals("string", jedis.type(key));

            String timeKey = "timeKey";
            jedis.set(timeKey, value);
            //设置过期时间
            jedis.expire(timeKey, 3);
            TimeUnit.SECONDS.sleep(1);
            //查看剩余生存时间，单位为秒，不同redis版本ttl()方法返回值含义不同
            assertEquals(Long.valueOf(2L), jedis.ttl(timeKey));
            //移除某个key的生存时间
            jedis.persist(timeKey);
            assertEquals(Long.valueOf(-1L), jedis.ttl(timeKey));
        }
        pool.close();
    }

    @Test
    public void testNumber() {
        try (Jedis jedis = pool.getResource()) {
            String numberKey = "numberKey";
            jedis.set(numberKey, "5");
            //+1的方法
            assertEquals(Long.valueOf(6L), jedis.incr(numberKey));
            //incrBy()  decrBy()可以设置增长或减少的幅度
            assertEquals(Long.valueOf(8L), jedis.incrBy(numberKey, 2));
            assertEquals(Long.valueOf(7L), jedis.decr(numberKey));
            assertEquals(Long.valueOf(5L), jedis.decrBy(numberKey, 2));
        }
    }

    @Test
    public void testHash() {
        try (Jedis jedis = pool.getResource()) {
            jedis.flushDB();
            String hashKey = "crm:user:infoHash:id1";
            Map<String, String> map = new HashMap<>();
            map.put("name", "def");
            jedis.hmset(hashKey, map);
            jedis.hset(hashKey, "vip", "true");
            jedis.hincrBy(hashKey, "age", 10);
            Map<String, String> resultMap = jedis.hgetAll(hashKey);
            //{name=def, vip=true, age=10}
//            System.out.println(resultMap);

            //查询指定fields的value
            List<String> queryValues = jedis.hmget(hashKey, "name", "age");
            assertThat(queryValues, contains("def", "10"));

            //查询所有fields的value
            List<String> allValues = jedis.hvals(hashKey);
            assertThat(allValues, contains("def", "true", "10"));

            jedis.hdel(hashKey, "age");
            //删除hash的hashKey，也就是一整个都被删掉了
//            jedis.del(hashKey,"age");
            assertThat(jedis.hvals(hashKey), contains("def", "true"));
            assertFalse(jedis.hexists(hashKey,"age"));
            assertFalse(jedis.exists("age"));
        }
    }

    /**
     * list是双向链表
     3 2 1 0
     */
    @Test
    public void testList() {
        try (Jedis jedis = pool.getResource()) {
            jedis.flushDB();
            String key = "list";
            //left push
            jedis.lpush(key, "1");
            jedis.lpush(key, "2");
            jedis.lpush(key, "3");
            //right push
            jedis.rpush(key, "0");

            //获取指定范围的值
            assertThat(jedis.lrange(key, 0, 1), contains("3", "2"));
            assertThat(listAll(jedis, key), contains("3", "2", "1", "0"));
            //获取列表长度
            assertEquals(Long.valueOf(4), jedis.llen(key));

            jedis.lpush(key, "4");
            jedis.lpush(key, "4");
            //删除指定个数的值
            jedis.lrem(key, 1, "4");
            assertThat(listAll(jedis, key), contains("4", "3", "2", "1", "0"));
            //删除区间之外的值
            jedis.ltrim(key, 0, 1);
            assertThat(listAll(jedis, key), contains("4", "3"));
            //最左边弹出一个值
            jedis.lpop(key);
            assertThat(listAll(jedis, key), contains("3"));
            //获取指定下标的值
            assertEquals("3", jedis.lindex(key, 0));
        }
        pool.close();
    }

    /**
     * 获取指定key的所有value
     * 列表负索引表示从右边开始计算，-1表示最右边第一个元素
     */
    private List<String> listAll(Jedis jedis, String key) {
        return jedis.lrange(key, 0, -1);
    }


    /***
     * 无序集合
     */
    @Test
    public void testSet() {
        try (Jedis jedis = pool.getResource()) {
            jedis.flushDB();
            String setKey = "setKey";
            jedis.sadd(setKey, "a");
            jedis.sadd(setKey, "b");
            jedis.sadd(setKey, "c");
            jedis.sadd(setKey, "c");
            //[a, c, b]
            System.out.println(jedis.smembers(setKey));
            //获取所有值   无序匹配   contains()就是有序
            assertThat(jedis.smembers(setKey), containsInAnyOrder("c", "b", "a"));
            assertThat(jedis.smembers(setKey), contains("a", "c", "b"));
            //删除
            jedis.srem(setKey, "b");
            assertThat(jedis.smembers(setKey), containsInAnyOrder("c", "a"));
            assertThat(jedis.smembers(setKey), contains("a", "c"));
            //判断元素是否在set中
            assertTrue(jedis.sismember(setKey, "c"));

            jedis.sadd("setKey1", "a1");
            jedis.sadd("setKey1", "b1");
            jedis.sadd("setKey1", "c1");
            jedis.sadd("setKey2", "a1");
            jedis.sadd("setKey2", "b2");
            jedis.sadd("setKey2", "c2");
            //交集
            assertThat(jedis.sinter("setKey1", "setKey2"), contains("a1"));
            //并集
            assertThat(jedis.sunion("setKey1", "setKey2"), containsInAnyOrder("a1", "b1", "c1", "b2", "c2"));
            //差集
            assertThat(jedis.sdiff("setKey1", "setKey2"), containsInAnyOrder("c1", "b1"));
            assertThat(jedis.sdiff("setKey2", "setKey1"), containsInAnyOrder("c2", "b2"));
        }
        pool.close();
    }

    /**
     * 有序集合类型zset(SortedSet)
     */
    @Test
    public void testSortedSet() {
        try (Jedis jedis = pool.getResource()) {
            jedis.flushDB();
            String key = "fruit";
            jedis.zadd(key, 8.0d, "apple");
            Map<String, Double> map = new HashMap<>(3);
            map.put("banana", 3.3d);
            map.put("orange", 6.5d);
            jedis.zadd(key, map);
            //获取score
            assertEquals(Double.valueOf(6.5d), jedis.zscore(key, "orange"));
            //获取排名，score从小到大，score值最小的成员排名为0
            assertEquals(Long.valueOf(1), jedis.zrank(key, "orange"));
            //获取指定区间内的成员,score 值递增从小到大排序
            Set<String> set = jedis.zrange(key, 0, -1);
            assertThat(set, contains("banana", "orange", "apple"));
            //获取score值最大的成员
            Set<String> maxSet = jedis.zrevrange(key, 0, 0);
            assertEquals("apple", maxSet.iterator().next());
        }
        pool.close();
    }

}
