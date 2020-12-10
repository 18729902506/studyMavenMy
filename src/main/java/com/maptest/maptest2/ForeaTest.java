package com.maptest.maptest2;

import java.util.*;

/***
 * @author shang
 * @date 2019/09/07
 * 对Map的遍历
 * Map中采用Entry内部类来表示一个映射项，映射项包含Key和Value
 * 每一个键值对就是一个Entry
 */
public class ForeaTest {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,3);
        map.put(2,6);

        Iterator<Map.Entry<Integer,Integer>>  iterator= map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry = iterator.next();
            int key  = entry.getKey();
            int value = entry.getValue();
            //1 3
            //2 6
            System.out.println(key+" "+value);
        }

        Map<String,String> map1 = new HashMap<>();
        map1.put("1","wang");
        map1.put("2","shang");
        //entrySet是Java中键值对的集合，Set里面的类型是Map.Entry,一般可以map.entrySet()得到
        //entrySet实现了Set接口，里面存放的是键值对，一个K对应一个V
        Set<Map.Entry<String,String>> entrySet = map1.entrySet();
        for (Map.Entry<String,String> entry: entrySet) {
            //1 wang
            //2 shang
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

        //keySet()得到的是键的集合，Set里面的类型是key的类型，来遍历key和value
        Set<String> set = map1.keySet();
        for (String v: set) {
            //1,wang
            //2,shang
            System.out.println(v+","+map1.get(v));
        }

        Collection<String> values = map1.values();
        for (String v: values) {
            //value=wang
            //value=shang
            System.out.println("value="+v);
        }
    }
}
