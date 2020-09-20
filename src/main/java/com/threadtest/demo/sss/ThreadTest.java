package com.threadtest.demo.sss;

/***
 * 创建线程方式1：继承Thread类，重写run()方法，调用start()开启线程
 * 总结：注意，线程开启不一定立即执行，由CPU调度执行
 * @author shang
 */
public class ThreadTest extends Thread {

    @Override
    public void run(){
        //run方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码------" + i);
        }
    }

    public static void main(String[] args) {
        //main线程，主线程

        //创建一个线程对象
        ThreadTest threadTest = new ThreadTest();
        //调用start()方法开启线程（两个线程同时运行，我在看代码和我在学习多线程是交替执行的）
        //如果是调用run()方法，run()方法执行完的，才会执行我在学习多线程
        threadTest.start();
        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程----" + i);
        }
    }

}
