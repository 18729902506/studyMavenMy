package com.threadtest.synsss5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/***
 * 测试回顾总结线程的创建
 */
public class ThreadNew {

    public static void main(String[] args) {
        //继承Thread，可以这样启动
        new MyThread().start();

        //需要一个代理类,前面new Thread是它的代理类对象，Runnable方式的额启动
        new Thread(new MyThread2()).start();

        FutureTask<Integer> futureTask = new FutureTask(new MyThread3());
        new Thread(futureTask).start();
        Integer integer = null;
        try {
            integer = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(integer);
    }
}

/***
 * 继承Thread类
 */
class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread1");
    }
}

/**
 * 实现Runnable接口
 */
class MyThread2 implements Runnable{

    @Override
    public void run() {
        System.out.println("MyThread2");
    }
}

/***
 * 实现Callable接口
 */
class MyThread3 implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("MyThread3");
        return 100;
    }
}
