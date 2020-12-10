package com.breaktest;

public class Test {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1;i<=100;i++) {
            sum = sum + i;
            if (i == 100){
                System.out.println("-----");
            }
            break;
        }
        System.out.println(sum);
    }
}
