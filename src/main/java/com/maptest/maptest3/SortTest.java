package com.maptest.maptest3;

import java.util.*;

/***
 * @author shang
 * @date 2019/09/08
 * 根据TreeMap的key来进行排序
 * TreeMap默认是升序的，如果我们需要改变排序的方式，则需要使用比较器Comparator
 */
public class SortTest {
    public static void main(String[] args) {
        Map<String,String> map = new TreeMap<>(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1);
                    }
                }
//                Comparator.reverseOrder()
        );
        map.put("c","ccc");
        map.put("a","aaa");
        map.put("b","bbb");
        map.put("d","ddd");

        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()){
           String key =  iter.next();
            /***
             * d:ddd
             * c:ccc
             * b:bbb
             * a:aaa
             */
            System.out.println(key+":"+map.get(key));
        }
    }
}
