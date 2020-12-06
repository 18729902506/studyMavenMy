package com.threadtest.methodtest.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/***
 * 定义5个线程，每个线程+10，对a进行操作，共计加到50，如果采用a++的形式进行操作，不会达到50
 * @author shang
 */
public class AtomicIntegerTest2 {

    static AtomicInteger a = new AtomicInteger();

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() ->{
                for (int j = 0; j < 10; j++) {
                    try {
                        //进行自增操作，先+1，然后获得新值
                        System.out.println(a.incrementAndGet());
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            threads[i].start();
        }
    }

}
