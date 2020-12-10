package com.h5test;

import java.util.stream.IntStream;

public class Test {

    /**
     * 第二代身份证号码位数权重
     */
    private static final int[] WEIGHT_OF_ID_NUMBER = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};

    private static final String[] CHECK_CODE_OF_ID_NUMBER = {"1", "0", "X", "9", "8", "7", "6", "5", "4", "3", "2"};

    public static void main(String[] args) {

        //17
        System.out.println(WEIGHT_OF_ID_NUMBER.length);

        String id = "610431199610253987";
        int sum = IntStream.range(0, WEIGHT_OF_ID_NUMBER.length).map(i -> (id.charAt(i) - '0') * WEIGHT_OF_ID_NUMBER[i]).sum();
        if (!CHECK_CODE_OF_ID_NUMBER[sum % 11].equalsIgnoreCase(String.valueOf(id.charAt(17)))) {
            System.out.println(CHECK_CODE_OF_ID_NUMBER[sum % 11]);
            System.out.println(id.charAt(17));
            System.out.println("参数错误");
        }
    }
}
