package com.demo.testthree;

import com.demo.testtwo.Apple;

/***
 * @author S
 */
public class AppleGreenColorPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return "green".equals(apple.getColor());
    }
}
