package com.test.testfour;

import com.demo.testtwo.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Test {
    /**
     * 目标引用 :: 方法的名称
     */
    public static void main(String[] args) {

    Function<String,Integer> stringToInteger = (String s) -> Integer.parseInt(s);
    Function<String,Integer> getStringToInteger1 = Integer::parseInt;

//         lambda Expression                      方法引用
//        (String s) -> System.out.println(s);    System.out::println
//        (String s) -> s.toUpperCase()          String::toUpperCase

        List<String> str = Arrays.asList("a","b","A","B");
        str.sort((s1,s2) -> s1.compareToIgnoreCase(s2));

        str.sort(String :: compareToIgnoreCase);

        BiPredicate<List<String>,String> contains = (list,element) -> list.contains(element);

        BiPredicate<List<String>,String> contains2 = List::contains;

        //对于一个现有的构造函数，可以利用它的名字和关键字new来创建它的一个引用     类名::new
        //构造函数引用指向默认的Apple()构造函数
        Supplier<Apple> c1 = Apple ::new;
        Supplier<Apple> c2 = () -> new Apple();
        //调用Supplier的get方法将产生一个新的Apple
        Apple a1 = c1.get();

//        Function<Integer,Apple> c3 = Apple :: new;
























    }
}
