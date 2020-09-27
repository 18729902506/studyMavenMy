package com.threadtest.demo.synsss5;

/***
 * 不安全的买票
 * 有人拿到了第-1张票。所以线程不安全
 */
public class UnSafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();
        //三个人操作同一个对象
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
            return;
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //买票
        System.out.println(Thread.currentThread().getName() + "拿到了" + ticketNums--);
    }
}
