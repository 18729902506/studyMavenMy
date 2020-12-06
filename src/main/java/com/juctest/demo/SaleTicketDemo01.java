package com.juctest.demo;

/***
 * 真正的多线程开发，公司中的开发
 * 线程就是一个单独的资源类，没有任何的附属操作，就是属性和方法
 * 三个线程同时去卖票
 * 多线程的情况下，不加锁就是不安全的，只要涉及到并发编程，一定要有锁
 * @author shang
 */
public class SaleTicketDemo01 {

    public static void main(String[] args) {
        //并发：多线程操作同一个资源类，把资源类丢入线程即可
        Ticket ticket = new Ticket();
        //@FunctionalInterface：函数式接口，jdk1.8  lambda表达式  (参数)->{代码}
        new Thread(() -> {
            for (int i = 1; i < 60; i++) {
                ticket.sale();
            }
         },"A").start();

        new Thread(() -> {
            for (int i = 1; i < 60; i++) {
            ticket.sale();
        }
        },"B").start();
        
        new Thread(() -> {
            for (int i = 1; i < 60; i++) {
                ticket.sale();
            }
         }, "c").start();
    }
}


/***
 * 资源类    操作的属性，对应的方法
 * 这才是真正的OOP，面向对象编程
 */
class Ticket{
    private int number = 50;

    /**
     * 卖票的方式
     * synchronized  本质：队列+锁
     */
    public synchronized void sale(){
        if (number > 0){
            System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) +"票，剩余：" + number);
        }
    }

}
