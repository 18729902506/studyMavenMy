package com.demo.testthree;

import com.demo.testtwo.Apple;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * @author S
 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                                              new Apple(155,"green"),
                                              new Apple(120,"red"));
        //结果是一个包含一个155gApple的List
        List<Apple> heavyApples = filterApples(inventory,new AppleHeavyWeightPredicate());
        //结果是一个包含两个绿Apple的List
        List<Apple> greenApples = filterApples(inventory,new AppleGreenColorPredicate());
        //heavyApples:[Apple(weight=155, color=green)]
        System.out.println("heavyApples:"+heavyApples);
        //greenApples:[Apple(weight=80, color=green), Apple(weight=155, color=green)]
        System.out.println("greenApples:"+greenApples);

        //使用lambda表达式
        List<Apple> result = filterApples(inventory,(Apple apple) -> "red".equals(apple.getColor()));
    }


    public static List<Apple> filterApples(List<Apple> inventory,ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory) {
            if (p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }
}
