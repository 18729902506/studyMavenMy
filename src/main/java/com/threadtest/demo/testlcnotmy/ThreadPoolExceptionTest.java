package com.threadtest.demo.testlcnotmy;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * 测试线程池内的线程任务发生异常
 */
public class ThreadPoolExceptionTest {
    /**
     * 测试线程池execute()线程出现异常
     */
    @Test
    public void testExecute() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = newSingleThreadExecutor();
        //外部捕获异常，能够成功捕获
        try {
            threadPoolExecutor.execute(() -> {
                System.out.println(getCurrentThreadName() + ":execute1");
                throwMockException();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        //休眠1秒让下面的任务一定能够从线程池中获取到线程
        TimeUnit.SECONDS.sleep(1L);

        threadPoolExecutor.execute(() -> {
            //与execute1的线程名称不同，说明execute1的线程被线程池移除掉了
            System.out.println(Thread.currentThread().getName() + ":execute2");
            //内部捕获异常
            try {
                throwMockException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        TimeUnit.SECONDS.sleep(1L);

        threadPoolExecutor.execute(() -> {
            //与execute2的线程名称相同，说明execute2内部捕获了异常，线程不会被线程池移除
            System.out.println(Thread.currentThread().getName() + ":execute3");
        });
        TimeUnit.SECONDS.sleep(1L);
    }

    /**
     * 测试线程池submit()线程出现异常
     */
    @Test
    public void testSubmit() throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = newSingleThreadExecutor();
        //无法捕获到异常
        try {
            threadPoolExecutor.submit(() -> {
                System.out.println(getCurrentThreadName() + ":submit1");
                throwMockException();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        TimeUnit.SECONDS.sleep(1L);

        threadPoolExecutor.submit(() -> {
            //线程名没有发生改变
            System.out.println(Thread.currentThread().getName() + ":submit2");
            //内部可以捕获到异常
            try {
                throwMockException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        TimeUnit.SECONDS.sleep(1L);

        Future future = threadPoolExecutor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + ":submit3");
            throwMockException();
        });
        //调用get()方法时才可以捕获到异常
        try {
            future.get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        TimeUnit.SECONDS.sleep(1L);
    }

    private ThreadPoolExecutor newSingleThreadExecutor() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        return new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(), namedThreadFactory);
    }

    private String getCurrentThreadName() {
        return Thread.currentThread().getName();
    }

    private void throwMockException() {
        throw new RuntimeException("MockException");
    }
}
