package com.threadtest.demo.synsss5;

/***
 * 不安全的取钱
 * 两个人去银行取钱，账户
 * 基金余额为：50
 * 你手里的钱:50
 * gf钱不够了，取不了
 * @author shang
 */
public class UnSafeBank {

    public static void main(String[] args) {
        Account account = new Account(100,"基金");
        Drawing you = new Drawing(account, 50,"你");
        Drawing gf = new Drawing(account,100,"gf");
        you.start();
        gf.start();
    }
}

/**
 * 账户类
 */
class Account{
    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread{

    /**
     * 账户
     */
    Account account;

    /**
     * 取了多少钱
     */
    int drawingMoney;

    /**
     * 现在手里有多少钱
     */
    int nowMoney;

    public Drawing(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }


    /**
     * synchronized默认锁的是本身，也就是this
     * 如果给这个方法枷锁，就锁的是run()，也就是银行，但是我们操作的对象（增删改）并不是银行，
     */
    @Override
    public void run() {

        //锁账户，锁的对象就是变化的量，需要增删改的对象，锁住，就能保证安全
        synchronized (account){
            //判断有没有钱
            if (account.money - drawingMoney < 0){
                System.out.println(Thread.currentThread().getName() + "钱不够了，取不了");
                return;
            }
            //sleep可以放大问题的发生性
            // 基金余额为：-50
            // 基金余额为：-50
            // gf手里的钱:100
            // 你手里的钱:50
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额 = 余额 - 你取的钱
            account.money = account.money - drawingMoney;
            //你手里的钱
            nowMoney = nowMoney + drawingMoney;

            System.out.println(account.name + "余额为："+account.money);
            //Thread.currentThread().getName() = this.getName
            System.out.println(this.getName() + "手里的钱:" + nowMoney);
        }

    }
}