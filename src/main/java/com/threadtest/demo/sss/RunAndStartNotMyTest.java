package com.threadtest.demo.sss;

import org.junit.Test;

/***
 * @author shang
 */
public class RunAndStartNotMyTest {

    private class MyThread implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println(i);
            }
        }
    }

    @Test
    public void test(){
        Thread thread = new Thread(new MyThread());
        thread.run();
        System.out.println("main thread");
    }
}
