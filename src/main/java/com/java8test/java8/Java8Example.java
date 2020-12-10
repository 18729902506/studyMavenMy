package com.java8test.java8;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * @author S
 * Java 8 Stream Filter 过滤  null 值
 */
public class Java8Example {
    public static void main(String[] args) {
        Stream<String> language = Stream.of("java","python","node",null,"ruby",null,"php");
        List<String> result = language.collect(Collectors.toList());
        //当有值为空时，就过滤掉
        List<String> result1 = language.filter(x -> x != null).collect(Collectors.toList());
        //或者使用过滤器 Objects::nonNull
        List<String> result2 = language.filter(Objects::nonNull).collect(Collectors.toList());
        //输出：java  python  node  null  ruby  null   php
        result.forEach(System.out::println);
        //输出：java  python  node  ruby  php
        result1.forEach(System.out::println);
        result2.forEach(System.out::println);
    }
}
