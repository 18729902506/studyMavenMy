package com.threadtestOri.sss3.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author shang
 */
public class TestPool {

    public static void main(String[] args) {
        //创建服务，创建线程池
        //参数为：线程池大小
        ExecutorService service = Executors.newFixedThreadPool(10);
        //执行runnable接口的实现类
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //关闭连接
        service.shutdown();
    }


}

class MyThread implements Runnable {
    @Override
    public void run() {
        //如果能成功输出这句话，说明四个线程都已经跑起来了
        //pool-1-thread-1
        //pool-1-thread-4
        //pool-1-thread-3
        //pool-1-thread-2
        System.out.println(Thread.currentThread().getName());
    }
}
