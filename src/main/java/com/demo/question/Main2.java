package com.demo.question;

/***
 * @author S
 * 计算101-200之间共有多少个素数（除了1和它本身，再没有数可以被它整除）
 * Math.sqrt(i):给i开平方,返回正平方跟
 */
public class Main2 {

    public static void main(String[] args){
        int count = 0;
        for (int i = 101; i <200; i++) {
            boolean b = false;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                //除了1和它本身，i还可以整除其它数，b就是false
                if(i%j==0){
                    b=false;
                    break;
                }else{
                    b=true;
                }
            }
            //如果b为真，就把它打印出来
            if(b){
                count++;
                System.out.print(i+"\t");
            }
        }
        System.out.println("一共有"+count+"个素数");
    }
}
