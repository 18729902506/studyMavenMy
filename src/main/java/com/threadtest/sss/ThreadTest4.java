package com.threadtest.sss;

/***
 * 多个线程同时操作同一个对象
 * 买火车票的例子
 * 发现问题：多个线程操作同一个资源的情况下，线程不安全，数据紊乱。线程同步的时候在来解决，初识并发问题
 * @author shang
 */
public class ThreadTest4 implements Runnable {

    /**
     * 票数
     */
    private Integer ticketNums = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNums <= 0) {
                break;
            }
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //打印线程的名字 Thread.currentThread().getName()
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticketNums-- + "票");
        }
    }

    /**
     * sss拿到了第10票
     * bbb拿到了第9票
     * aaa拿到了第8票
     * sss拿到了第7票
     * aaa拿到了第6票
     * bbb拿到了第5票
     * sss拿到了第4票
     * bbb拿到了第3票
     * aaa拿到了第2票
     * sss拿到了第1票
     * bbb拿到了第0票
     * aaa拿到了第0票
     *
     * @param args
     */
    public static void main(String[] args) {
        ThreadTest4 ticket = new ThreadTest4();
        new Thread(ticket, "sss").start();
        new Thread(ticket, "aaa").start();
        new Thread(ticket, "bbb").start();
    }
}
