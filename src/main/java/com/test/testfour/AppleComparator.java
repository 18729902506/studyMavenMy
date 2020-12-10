package com.test.testfour;

import com.demo.testtwo.Apple;

import java.util.Collections;
import java.util.Comparator;

public class AppleComparator implements Comparable<Apple> {

    public int compare(Apple a1,Apple a2){
        return a1.getWeight().compareTo(a2.getWeight());
    }

    @Override
    public int compareTo(Apple o) {
        return 0;
    }

    Comparator<Apple> c = Comparator.comparing(Apple::getWeight);
}
