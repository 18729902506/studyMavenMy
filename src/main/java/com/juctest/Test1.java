package com.juctest;

/***
 * 查看CPU的核数
 */
public class Test1 {
    public static void main(String[] args) {
        //8  获取CPU的核数
        //CPU密集型  IO密集型
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
