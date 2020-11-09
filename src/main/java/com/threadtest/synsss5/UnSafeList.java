package com.threadtest.synsss5;

import java.util.ArrayList;
import java.util.List;

/***
 * 线程不安全的集合
 * 两个线程同一瞬间，操作了同一个位置，把两个数组添加到了同一个位置，就把前面的覆盖了
 * @author shang
 */
public class UnSafeList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //开启一万个线程，把线程的名字添加到集合中
        for (int i = 0; i < 10000; i++) {
            new Thread(() ->{
                //锁成功了，就是一万
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出来的集合总和始终不到一万，说明了集合是线程不安全的
        System.out.println(list.size());
    }
}
