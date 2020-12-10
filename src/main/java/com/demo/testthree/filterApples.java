package com.demo.testthree;

import com.demo.testtwo.Apple;
import java.util.ArrayList;
import java.util.List;

public class filterApples {

    List<Apple> inventory;
    public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    List<Apple> redAndHeavyApples = filterApples(inventory,new AppleRedAndHeavyPredicate());
}
