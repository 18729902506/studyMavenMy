package com.java8test.java8;

/***
 * @author
 * @date 2019/10/20
 */
public class Java8Examples3 {

    public static void main(String[] args) {
        /***
         * 使用lambda表达式:允许以内联的形式为函数式接口的抽象方法提供实现，并把整个表达式作为函数式接口的实例
         * 具体来说就是函数式接口一个具体实现的实例
         */
        Runnable r1 = () -> System.out.println("Hello World1");

        /***
         * 使用匿名内部类:需要提供一个具体实现，然后再直接内联将它实例化
         */
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World2");
            }
        };

        process(r1);
        process(r2);
        //利用直接传递的lambda表达式来打印
        process(() -> System.out.println("Hello World3"));
    }

    private static void process(Runnable r){
        r.run();
    }
}
