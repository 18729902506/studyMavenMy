package com.threadtest.demo.synsss5;

/***
 * 不安全的买票
 * 有人拿到了第-1张票。所以线程不安全，因为我们没有让他们去排队买，所以当剩下一张票的时候，都把1拷贝到自己的内存中，去进行买票
 * 想要线程安全，就得队列+锁
 */
public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();
        //三个人操作同一个对象（三个人去了车站）
        new Thread(station,"苦逼的我").start();
        new Thread(station,"牛逼的你们").start();
        new Thread(station,"可恶的黄牛党").start();
    }
}

class BuyTicket implements Runnable{

    //票数
    private int ticketNums = 10;

    //线程外部停止的方式，设置标志位
    boolean flag = true;

    @Override
    public void run() {
        //买票
        while (flag){
            buy();
        }
    }

    private void buy(){
        //判断是否有票
        if (ticketNums <= 0){
            flag = false;
            //就停止
            return;
        }
        //sleep可以放大问题的发生性，程序存在不安全的情况下使用
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName() + "拿到了" + ticketNums--);
    }
}
