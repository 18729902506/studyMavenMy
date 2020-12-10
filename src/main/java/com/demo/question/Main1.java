package com.demo.question;

/***
 * @author S
 * 计算兔子的问题-----运用递归的算法
 */
public class Main1 {

    public static int getResult(int n){
        if (n ==1 || n==2){
            return 1;
        }else{
            return getResult(n-1)+getResult(n-2);
        }
    }
    public static void main(String[] args) {
        System.out.println("第1个月的兔子对数：1");
        System.out.println("第2个月的兔子对数：1");
        for (int i = 3;i<=12;i++) {
            System.out.println("第"+i+"个月的兔子对数为："+getResult(i));
        }
    }

}
