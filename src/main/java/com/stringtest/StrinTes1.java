package com.stringtest;

public class StrinTes1 {

    public static void main(String[] args) {
        String a = "|SALES_DEPARTMENT|";
        for (String m : a.split("\\|")){
            System.out.println(m);
        }

        System.out.println(a.split("\\|"));

        String Str = ("Welcome-to-W3CSchool.com");

        System.out.println("返回值 :" );
        for (String retval: Str.split("-")){
            System.out.println(retval);
        }
    }
}
