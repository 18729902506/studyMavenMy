package com.threadtest.synsss5;

/***
 * 测试生产者消费者模型，利用缓冲区解决：管程法
 * 生产者，消费者，产品，缓冲区
 * @author shang
 */
public class TestPc {

    public static void main(String[] args) {
        SyncContainer container = new SyncContainer();
        new Productor(container).start();
        new Consumer(container).start();
    }
}

/**生产者*/
class Productor extends Thread{
    private SyncContainer container;
    public Productor(SyncContainer container){
        this.container = container;
    }

    /**生产*/
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            container.push(new Chicken(i));
            System.out.println("生产了" + i + "只鸡");
        }
    }
}

/**消费者*/
class Consumer extends Thread{
    private SyncContainer container;
    public Consumer(SyncContainer container){
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了第--->" + container.pop().id + "只鸡");
        }
    }
}

/**产品*/
class  Chicken{
    /**产品编号*/
    int id;

    public Chicken(int id) {
        this.id = id;
    }
}

/**缓冲区*/
class SyncContainer{

    /**需要一个容器大小*/
    private Chicken[] chickens = new Chicken[10];

    /**容器计数器*/
    private int count = 0;

    /**生产者放入产品*/
    public synchronized void push(Chicken chicken){
        //如果容器满了，就需要消费者消费
        if (count == chickens.length){
            //通知消费者进行消费，生产者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果没有满，我们就需要丢入产品
        chickens[count] = chicken;
        count++;
        //可以通知消费者消费了
        this.notifyAll();
    }


    /**消费者消费产品*/
    public synchronized Chicken pop(){
        //判断能否消费
        if (count == 0){
            //等待生产者生产，消费者等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //如果count!=0,也就是有东西消费消费，就去消费
        count--;
        Chicken chicken = chickens[count];
        //吃完了，通知生产者生产
        this.notifyAll();
        return chicken;
    }

}
