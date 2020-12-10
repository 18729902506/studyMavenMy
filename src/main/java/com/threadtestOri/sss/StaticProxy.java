package com.threadtestOri.sss;

/***
 * 实现静态代理对比Thread
 * 静态代理模式总结：
 * 真实对象和代理对象都要实现同一个接口
 * 代理对象要代理真实的角色
 * 好处：代理对象可以做很多真实对象做不了的事情
 *      真实对象就专注做自己的事情
 */
public class StaticProxy {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我爱你");
            }
        }).start();


        new Thread(() -> System.out.println()).start();

        new WeddingCompany(new You()).happyMarry();


        //结婚只要我把我给婚庆公司就可以了
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.happyMarry();
    }
}

/***
 * 人间四大喜事
 * 久旱逢甘霖
 * 他乡遇故知
 * 洞房花烛夜
 * 金榜题名时
 */
interface Marry{
    void happyMarry();
}

/**
 * 真实角色，你去结婚
 */
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("我要结婚啦，超开心");
    }
}

/***
 * 代理角色，帮助你结婚
 * 代理对象要有一个参数，必须传进去，就可以调用代理对象的方法
 */
class WeddingCompany implements Marry{

    //代理谁-->真实目标角色
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        System.out.println("结婚前，准备");
        //这就是真实对象，真实对象是代理来的
        this.target.happyMarry();
        System.out.println("结婚后，收尾款");
    }
}