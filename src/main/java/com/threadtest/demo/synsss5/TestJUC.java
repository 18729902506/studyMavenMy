package com.threadtest.demo.synsss5;

import java.util.concurrent.CopyOnWriteArrayList;

/***
 * java.util.concurrent  JUC并发包
 * 测试JUC安全类型的集合
 * 手动实现的线程安全的集合，不手动实现，就用synchronized代码块，也可以实现线程安全的集合
 * @author shang
 */
public class TestJUC {

    public static void main(String[] args) {
        //线程安全的list
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
            }).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
