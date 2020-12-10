package com.demo.question;

/***
 * @author S
 * 三位数水仙花数的计算
 * 153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
 */
public class Main3 {

    public static void main(String[] args) {
        int m1,m2,m3;
        for (int b = 101;b<1000;b++){
            m3=b/100;
            m2=b%100/10;
            m1=b%10;
            if (m3*m3*m3+m2*m2*m2+m1*m1*m1 == b){
                System.out.println(b+"是一个水仙花数");
            }
        }
    }
}
