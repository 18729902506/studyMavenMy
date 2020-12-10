package com.threadtestOri.testlcnotmy;

import org.junit.Test;
import java.util.concurrent.TimeUnit;

/**
 * 自己写一个线程的时候，需要去内部try catch异常，（catch异常，然后再去记录日志）
 * 因为主线程无法捕获子线程的异常
 */
public class ThreadExceptionTest {
    /**
     * 测试线程内部抛异常并不进行捕获
     */
    @Test
    public void withoutInnerTryCatch() {
        //线程内部逻辑只会执行一次后，线程终止
        Thread thread = new Thread(new ExceptionThreadWithoutTryCatch(), "ExceptionThreadWithoutTryCatch");
        thread.start();
        sleep(30);
    }

    /**
     * 测试线程内部抛异常并不进行捕获，在外部进行捕获
     */
    @Test
    public void withOuterTryCatch() {
        try {
            Thread thread = new Thread(new ExceptionThreadWithoutTryCatch(), "ExceptionThreadWithoutTryCatch");
            thread.start();
        } catch (Exception e) {
            //主线程无法捕获到子线程的异常，不会打印
            System.out.println("catch exception...");
            e.printStackTrace();
        }
        sleep(30);
    }

    /**
     * 测试线程内部抛异常并在线程内部进行捕获
     */
    @Test
    public void exceptionThreadWithTryCatch() {
        Thread thread = new Thread(new ExceptionThreadWithTryCatch(), "ExceptionThreadWithTryCatch");
        thread.start();
        sleep(30);
    }

    /**
     * setUncaughtExceptionHandler()后，可以成功捕获到异常，不过子线程还是终止了
     */
    @Test
    public void setUncaughtExceptionHandler() {
        Thread thread = new Thread(new ExceptionThreadWithoutTryCatch(), "ExceptionThreadWithoutTryCatch");
        thread.setUncaughtExceptionHandler((t, e) -> {
            System.out.println("catch exception...");
            e.printStackTrace();
        });
        thread.start();
        sleep(30);
    }

    private class ExceptionThreadWithoutTryCatch implements Runnable {
        @Override
        public void run() {
            while (true) {
                sleep(1);
                System.out.println(Thread.currentThread().getName() + " run");
                throwMockException();
            }
        }
    }

    private class ExceptionThreadWithTryCatch implements Runnable {
        @Override
        public void run() {
            while (true) {
                //如果不进行异常捕获，一旦出现异常，线程将不再运行，即使是后面异常问题已经恢复
                try {
                    sleep(2);
                    System.out.println(Thread.currentThread().getName() + " run");
                    throwMockException();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void throwMockException() {
        throw new RuntimeException("MockException");
    }

    private void sleep(int second) {
        try {
            TimeUnit.SECONDS.sleep(second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}