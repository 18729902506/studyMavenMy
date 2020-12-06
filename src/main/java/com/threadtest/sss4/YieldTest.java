package com.threadtest.sss4;

/**
 * @author shang
 * 礼让，表示A先进去后，想进行礼让，就又出来了，然后和B一起等待CPU的调度，而不是说就让给B了
 *      所以也就是说礼让不一定成功，还是要看CPU的心情，也就是让CPU重新进行调度
 * 将线程从运行状态转化为就绪状态
 * 礼让线程，让当前正在执行的线程暂停，但是不阻塞
 */
public class YieldTest {

    public static void main(String[] args) {
        MyYield myYield = new MyYield();
        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();
    }
}

class MyYield implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "线程开始执行");
        //礼让  可能A跑完，才让B跑，也可能A礼让成功，让B跑一个，自己再跑
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + "线程停止执行");
    }
}
