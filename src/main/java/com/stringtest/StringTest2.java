package com.stringtest;

public class StringTest2 {

    public static void main(String[] args) {
        String str = "www-you-com";
        String[] temp;
        temp = str.split("-"); // 分割字符串
        // 普通 for 循环
        for(int i =0; i < temp.length ; i++){
            //  www  you  com
            System.out.print(temp[i]+" ");
        }

        //--java for each循环输出的方法--
        String str1 = "www.W3CSchool.cn";
        String[] temp1;
        //分割字符串，  .需要进行转义
        for(String x : str1.split("\\.")){
            //www  W3CSchool cn
            System.out.print(x+" ");
        }
    }
}
