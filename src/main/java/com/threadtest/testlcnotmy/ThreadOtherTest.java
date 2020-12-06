package com.threadtest.testlcnotmy;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/***
 * thread.join()方法：通常都是main线程等到其他多个线程执行完毕后再继续进行，其他多个线程之间并不需要互相等待
 * join()方法必须在start()方法后调用才有意义，
 * java中如何让多线程按照自己指定的顺序来执行？其实就是通过Thread.join()来实现的
 * 通过join()来等待线程执行的结果，类似于future的功能
 * join()方法底层就是通过wait()/notifyAll()来实现线程的通信从而达到线程阻塞的目的
 * @author shang
 */
public class ThreadOtherTest {

    /***
     * 实现Runnable接口
     * @throws InterruptedException 抛异常
     */
    @Test
    public void test1() throws InterruptedException {
        //创建线程时指定有意义的线程名称，方便出错时回溯
        Thread thread = new Thread(new RunnableThread(), "RunnableThread");
        //运行结果：RunnableThread-runnable-start-begin-
        thread.start();
        // 调用（main）线程等待该线程完成后，才能继续往下运行，
        // 不加这句话，表示main线程和thread线程是并行的，一起执行，加上这句话，程序就变成了顺序执行，
        // 挂起主线程，主线程需要等到thread线程结束后再恢复，避免主线程先结束看不到打印语句
        thread.join();
    }

    private class RunnableThread implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "-runnable-start-begin-");
        }
    }

    /***
     * 继承Thread
     * @throws InterruptedException 抛异常
     */
    @Test
    public void test2() throws InterruptedException {
        ThreadTest threadTest = new ThreadTest("ThreadThread");
        //运行结果：main-thread-start-begin-
        threadTest.run();
        threadTest.join();
    }

    /***
     * 继承Thread的缺点：该类不能再继承其他类了
     */
    private class ThreadTest extends Thread {
        ThreadTest(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "-thread-start-begin-");
        }
    }

    /***
     * 实现Callable接口
     * @throws ExecutionException 抛异常
     * @throws InterruptedException 抛异常
     */
    @Test
    public void test3() throws ExecutionException, InterruptedException {
        //方式1
        FutureTask<Integer> futureTask = new FutureTask<>(new CallableThread());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
        //方式2
        System.out.println(Executors.newCachedThreadPool().submit(new CallableThread()).get());
    }

    private class CallableThread implements Callable<Integer> {
        /***
         * 注意callable和Runnable的区别
         * 可以返回结果并可以抛出异常
         * @return 返回结果
         * @throws Exception 抛异常
         */
        @Override
        public Integer call() throws Exception {
            TimeUnit.SECONDS.sleep(3);
            return new Random().nextInt(30);
        }
    }

    /***
     * 函数式编程的写法
     * lambda
     */
    @Test
    public void test4() {
        new Thread(() -> System.out.println("MyThread lambda1")).start();
    }

    /***
     * 测试线程内部抛异常
     * @throws InterruptedException 抛异常
     */
    @Test
    public void test5() throws InterruptedException {
        Thread thread = new Thread(new ExceptionThread(), "ExceptionThread");
        thread.start();
        TimeUnit.SECONDS.sleep(30);
    }

    private class ExceptionThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + "name");
                throwException();

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        private void throwException() {
            throw new RuntimeException();
        }
    }

}
