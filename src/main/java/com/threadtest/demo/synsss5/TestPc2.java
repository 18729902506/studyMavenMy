package com.threadtest.demo.synsss5;

import lombok.SneakyThrows;

/**
 * 测试生产者消费者问题2：信号灯法，标志位解决法
 * 两个线程都在做自己的事情，通过wait()和notifyAll()两个方法，让线程暂时等待，或者结束等待，去唤醒另一个线程
 * 什么时候去通知另一个线程该干什么事？用wait()和notifyAll()方法
 *
 * @author shang
 */
public class TestPc2 {
    public static void main(String[] args) {
        TV tv = new TV();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

/**
 * 生产者--->演员
 */
class Player extends Thread {
    TV tv;
    public Player(TV tv) {
        this.tv = tv;
    }

    @SneakyThrows
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                this.tv.play("快乐大本营正在播放");
            } else {
                this.tv.play("抖音：记录美好生活");
            }
        }
    }
}

/**
 * 消费者--->观众
 */
class Watcher extends Thread {
    TV tv;
    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            tv.watch();
        }
    }
}

/**
 * 产品--->节目
 */
class TV {

    /**
     * 表演的节目
     */
    String voice;

    boolean flag = true;

    /**
     * 表演
     */
    public synchronized void play(String voice) throws InterruptedException {
        if (!flag) {
            this.wait();
        }
        System.out.println("演员表演了:" + voice);
        //通知观众观看  通知唤醒
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }

    public synchronized void watch() {
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("观看了:" + voice);
        //通知演员表演
        this.notifyAll();
        this.flag = !this.flag;
    }
}
