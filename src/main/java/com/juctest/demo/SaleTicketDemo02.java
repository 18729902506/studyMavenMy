package com.juctest.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/***
 * 通过Lock锁或者synchronized锁都可以多线程在并发上的操作的安全性
 *
 * synchronized 与 Lock锁的区别：
 * 1、synchronized：内置的Java关键字  lock是一个Java类
 * 2、synchronized：无法判断获取锁的状态  Lock可以判断是否获取到了锁
 * 3、synchronized：会自动释放锁  Lock必须要手动释放锁，如果不释放锁，就会产生死锁
 * 4、synchronized：如果有两个线程，一个活的锁的同时，第二个要等待，如果获得锁都得阻塞了，线程2就一直要等待，傻傻的等。
 *    Lock锁就不一定会等待下去，它有一个尝试锁的方法lock.tryLock()
 * 5、synchronized：可重入锁，不可以中断的，非公平，这个东西不能改，因为它是关键字。Lock 可重入锁 可以判断锁，公平与非公平可以自己设置
 * 6、synchronized：适合锁少量的代码同步问题  Lock：适合锁大量的同步代码
 * @author shang
 */
public class SaleTicketDemo02 {

    public static void main(String[] args) {
        //并发：多线程操作同一个资源类，把资源类丢入线程即可
        Ticket2 ticket = new Ticket2();
        new Thread(() -> { for (int i = 1; i < 60; i++) ticket.sale(); },"A").start();
        new Thread(() -> { for (int i = 1; i < 60; i++) ticket.sale(); },"B").start();
        new Thread(() -> { for (int i = 1; i < 60; i++) ticket.sale(); },"C").start();
    }
}


/***
 * lock三部曲
 * 1、new ReentrantLOck();
 * 2、lock.lock();  加锁
 * 3、在finally()中，lock.unlock();   解锁
 */
class Ticket2 {
    private int number = 50;
    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();

        try {
            //业务代码
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票，剩余：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }
    }
}
