package com.maptest.maptest3;

import java.util.*;

/***
 * @author shang
 * @date 2019/09/08
 * 根据TreeMap的value来进行排序
 * 如果HashMap也需要排序，它是按照key的HashCode来实现的，也可以参照这个方法
 */
public class SortTest1 {
    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<>();
        map.put("d","ddd");
        map.put("s","sss");
        map.put("m","aaa");
        map.put("b","ccc");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        //将set集合转化为list
        List<Map.Entry<String,String>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
            @Override
            public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        Collections.sort(list, Comparator.comparing(Map.Entry::getValue));
        for (Map.Entry<String,String> mapping : list) {
            /***
             * m:aaa
             * b:ccc
             * d:ddd
             * s:sss
             */
            System.out.println(mapping.getKey()+":"+mapping.getValue());
        }
    }
}
