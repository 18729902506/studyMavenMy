package com.ziptest;

public class Test {

    public static void main(String[] args) {
        String fileName = "omgadmin.xlsx";
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //8
        System.out.println(fileName.lastIndexOf("."));
        // .xlsx
        System.out.println(suffix);
    }
}
