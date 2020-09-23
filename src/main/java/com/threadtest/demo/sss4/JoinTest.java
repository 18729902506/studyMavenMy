package com.threadtest.demo.sss4;

/***
 * @author shang
 * join合并线程，待此线程执行完成后，再执行其他线程，其他线程阻塞
 * 可以想象为插队
 */
public class JoinTest implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("线程VIP来了" + i);
        }
    }

    public static void main(String[] args) {
        //启动线程
        JoinTest joinTest = new JoinTest();
        Thread thread = new Thread(joinTest);
        thread.start();

        //主线程
        for (int i = 0; i < 500; i++) {
            if (i == 200){
                //插队，它把它自己的走完，才让别人走
                Thread.yield();
            }
            System.out.println("main" + i);
        }
    }
}
