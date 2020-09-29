package com.threadtest.demo.testlcnotmy;

import org.junit.Test;

/***
 * @author shang
 */
public class RunAndStartTest {

    private class MyThread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        }
    }

    /***
     * main thread
     * 0
     * 1
     * 2
     * 3
     * 4
     * 一般线程启动都是调用start()方法，调用start()方法后会立即返回，
     * 一个新的线程会启动并执行MyThread的run()方法，而执行test()方法的主线程会立即继续往下执行
     */
    @Test
    public void test(){
        Thread thread = new Thread(new MyThread());
        thread.start();
        System.out.println("main thread");
    }

    /***
     * 0
     * 1
     * 2
     * 3
     * 4
     * ---main thread---
     * 如果调用run()方法，将不会新启一个线程执行而会被执行test1()方法的线程执行
     */
    @Test
    public void test1(){
        Thread thread = new Thread(new MyThread());
        thread.run();
        //一定会在最后执行
        System.out.println("---main thread---");
    }
}
