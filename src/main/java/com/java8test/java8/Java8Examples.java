package com.java8test.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * @author
 * 流只能被遍历（消费）一次，一个流遍历一次，就会被关闭，不能进行2次遍历
 */
public class Java8Examples {
    public static void main(String[] args) {
        Stream<String> language = Stream.of("java","python","node",null,"ruby",null,"php");
        List<String> result = language.collect(Collectors.toList());
        //java python node null ruby null php
        result.forEach(System.out::println);


        Stream<String> language2 = Stream.of("java",null,"node",null,"php");
        //过滤掉为null的值，选出不为null的值
        List<String> result2 =  language2.filter(x -> x!=null).collect(Collectors.toList());
        //java node php
        result2.forEach(System.out::println);
    }
}
