package com.demo.testthree;

import com.demo.testtwo.Apple;

/***
 * @author S
 */
public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "red".equals(apple.getColor()) && apple.getWeight() > 150;
    }


}
