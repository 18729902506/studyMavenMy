package com.threadtest.demo.sss;

/***
 * @author shang
 * 创建线程方式2：实现Runnable接口，重写run()方法，执行线程需要丢入runnable接口实现类，调用start()方法
 * 推荐使用实现 Runnable接口，避免单继承的局限性，灵活方便，方便同一个对象被多个线程使用
 */
public class ThreadTest3 implements Runnable {

    @Override
    public void run(){
        //run方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("我在看代码------" + i);
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        ThreadTest3 threadTest3 = new ThreadTest3();
        //创建线程对象，通过线程对象来开启我们的线程，代理
        new Thread(threadTest3).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("我在学习多线程----" + i);
        }
    }

}
