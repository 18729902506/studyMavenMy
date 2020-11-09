package com.threadtest.sss;

/***
 * @author shang
 *  lambda表达式只能有一行代码的情况下，才能简化成为一行，如果有多行，就用花括号（代码块）包裹
 *  前提是：接口为函数式接口（接口里面只能有一个方法）
 *  多个参数也可以去掉参数类型，要去掉就都去掉，多于1个参数，必须用（）包裹参数
 *  love = (a,b,c) -> {};
 */
public class LambdaTest2 {

    public static void main(String[] args) {
        //匿名内部类的写法
       ILove love = new ILove() {
           @Override
           public void love(int a) {
               System.out.println("I Love You---" + a);
           }
       };


       //lambda表达式的写法
       ILove love1 = (int a) -> {
           System.out.println("I Love You---" + a);
       };


       //简化1，去掉参数类型
       love1 = (a) -> {
           System.out.println("I Love You---" + a);
       };

       //简化2：去掉括号
       love1 = a -> {
           System.out.println("I Love You---" + a);
       };

       //简化3：去掉花括号，因为花括号里面只有一行代码，所以可以进行简化
        love1 = a -> System.out.println("I Love You---" + a);

        love1.love(520);
    }
}

interface ILove{
    void love(int a);
}
