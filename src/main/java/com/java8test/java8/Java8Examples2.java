package com.java8test.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * @author
 */
public class Java8Examples2 {

    public static void main(String[] args) {


        String ss = "Hello";
        String[] aa = ss.split("");
        String[] bb = {"H","e","l","l","0"};
        String[] strings = {"Hello","World"};

        Stream.of(new String[] {"Hello", "World"})
                .flatMap(str -> Arrays.stream(str.split("")))
                .distinct()
                .collect(Collectors.toList());

        //Arrays.stream接收一个数组，返回一个流
        //使用map(),它返回的是结果集，map只能进行单一转化(一对一进行转化)，一个对象可以转化为另一个对象，但是不可以转化成对象数组
        //让每个数组变成一个单独的流
        List<Stream<String>> streamList = Arrays.asList(strings)
                                                .stream()
                                                .map(str -> str.split(""))
                                                .map(str -> Arrays.stream(str))
                                                .collect(Collectors.toList());

        //分布写(map)
        Stream<String[]> stream = Arrays.asList(strings)
                                        .stream()
                                        .map(str ->str.split(""));
        Stream<Stream<String>> streamStream = stream.map(strings1 -> Arrays.stream(strings1));
        List<Stream<String>> streamList1 = streamStream.collect(Collectors.toList());


        //使用flatMap()：作用是对流进行扁平化,flatMap既可以进行单一转化，也可以进行一对多，多对多的转化
        //也就是说，它是把一个流中的每个值都换成了另一个流，然后把所有的流连接起来称为一个流
        List<String> stringList = Arrays.asList(strings)
                                        .stream()
                                        .map(str -> str.split(""))
                                        .flatMap(str -> Arrays.stream(str))
                                        .collect(Collectors.toList());

        //分布写（流只能消费一次）flatMap
        Stream<String[]> stream1 = Arrays.asList(strings).stream().map(str -> str.split(""));
        Stream<String> stringStream = stream1.flatMap(string1 -> Arrays.stream(string1));
        List<String> stringList1 = stringStream.collect(Collectors.toList());

    }
}
