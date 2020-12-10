package com.demo.testfive;

import com.demo.testtwo.Apple;
import java.util.List;

public class Test {

   static List<Apple> inventory;
    public static void prettyPrintApple(List<Apple> inventory,
                                        AppleFormatter formatter){
        for (Apple apple :inventory){
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    public static void main(String[] args) {
        prettyPrintApple(inventory,new AppleFancyFormatter());
        prettyPrintApple(inventory,new AppleSimpleFormatter());
    }
}
