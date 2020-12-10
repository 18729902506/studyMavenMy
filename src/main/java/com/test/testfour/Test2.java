package com.test.testfour;

import java.util.function.Function;

public class Test2 {

    public static void main(String[] args) {

        Function<Integer,Integer> f = x -> x+1;
        Function<Integer,Integer> g = x -> x*2;
        Function<Integer,Integer> h = f.andThen(g);
        Function<Integer,Integer> m = f.compose(g);
        int result = h.apply(1);
        int result2 = m.apply(1);
        //4  先走f,再走g
        System.out.println(result);
        //3  先走g,再走f
        System.out.println(result2);
    }
}
