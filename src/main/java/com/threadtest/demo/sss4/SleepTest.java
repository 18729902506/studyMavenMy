package com.threadtest.demo.sss4;

import java.text.SimpleDateFormat;
import java.util.Date;

/***
 * @author shang
 * sleep():指定当前线程阻塞的毫秒数，存在异常，需要抛出
 * sleep时间达到后线程进入就绪状态
 * sleep可以模拟网络延时，倒计时等等
 * 每个对象都有一个锁，sleep不会释放锁
 *
 * 放大问题的发生性，要不然看不出代码存在的问题，其次可以发现，多个线程同时操作一个对象，不安全
 * 模拟网络延时，参照ThreadTest4类中，抢票的写法
 */
public class SleepTest {


    /***
     * 打印当前系统时间
     * @param args 参数
     * @throws InterruptedException 抛异常
     */
    public static void main(String[] args) throws InterruptedException {
//        tenDown();
        //获取系统当前时间
        Date startDate = new Date(System.currentTimeMillis());
        while (true){
            Thread.sleep(1000);
            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startDate));
            //更新当前时间
            startDate = new Date(System.currentTimeMillis());
        }

    }

    /***
     * 模拟倒计时  十秒钟的倒计时   一秒钟跑一次
     * @throws InterruptedException 抛异常
     */
    public static void tenDown() throws InterruptedException {
        int num = 10;
        while (true) {
            Thread.sleep(1000);
            System.out.println(num--);
            if (num <= 0) {
                break;
            }
        }
    }
}
