package com.threadtestOri.testlcnotmy;

import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.*;


public class JedisTest {

    private JedisPool pool;
    private int port = 6379;


    @Before
    public void init(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(10);
        pool = new JedisPool(jedisPoolConfig, "127.0.0.1", port);
    }

    @Test
    public void testJedis(){
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
    public void testString(){
        try (Jedis jedis = pool.getResource()){
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
            jedis.mset("key1","value1","key2","value2");
            List<String> valueList = jedis.mget("key1", "key2");
            assertThat(valueList, contains("value1", "value2"));
        }
        //Close poll when closing your application:
        pool.close();
    }
}
