package com.streatest.testtwo;

import java.util.Arrays;
import java.util.List;

/***
 * @author sss
 * @date 2019/10/27
 */
public class streaTest1 {

    public static void main(String[] args) {
        //2 4 8
        List<Integer> numbers = Arrays.asList(1,2,1,3,3,2,4,8);
         numbers.stream()
                .filter(i -> i%2 == 0)
                .distinct()
                .forEach(System.out::println);

        //2 4 6
        List<Integer> numbers1 = Arrays.asList(1,2,1,3,3,2,4,6,7,8,10);
        numbers1.stream()
                .filter(i -> i%2 == 0)
                .distinct()
                .limit(3)
                .forEach(System.out::println);

    }
}

