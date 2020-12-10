package com.stringtest;

import java.util.Arrays;
import java.util.List;

/***
 * Arrays.asList(split);
 * 这样得到的集合的长度是固定的，不能往集合中添加或者删除一个元素
 */
public class StringTest3 {

    public static void main(String[] args) {
        String pages = "1,3,6,2,8";
        String[] split = pages.split(",");
        List<String> list = Arrays.asList(split);
        list.add("v");
        for (String s : list){
            System.out.println(s);
        }
    }
}
