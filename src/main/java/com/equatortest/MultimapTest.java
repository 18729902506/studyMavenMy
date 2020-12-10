package com.equatortest;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MultimapTest {

    private Collection<String> strings;

    @Test
    public void test(){
//        Map<String, String> map = new HashMap<>();
        Multimap<String, String> map = ArrayListMultimap.create();
        map.put("customerName", "客户名称");
        map.put("customerName","defaultConverter");
        map.put("businessType","新金融客户类型");
        map.put("businessType","dictConverter");
        map.put("industryType","行业");
        map.put("industryType","dictConverter");
        map.put("institutionType","客户类型");
        map.put("institutionType","dictConverter");

        for (String key : map.keySet()){
//            System.out.println(map.get(key).iterator().next());
            Collection<String> strings = map.get(key);
            Object[] arr = strings.toArray();
            for (int i = 0;i<=arr.length;i++){
                System.out.println(arr[1]);
            }
        }
    }
}
