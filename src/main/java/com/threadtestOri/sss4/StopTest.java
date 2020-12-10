package com.threadtestOri.sss4;

/***
 * @author shang
 * 测试停止线程
 * 建议线程正常停止   利用次数，不建议死循环
 * 建议使用标志位     设置一个标志位，当flag = false，则终止线程运行
 * 不要使用stop或者destroy等过时或者JDK不建议使用的方法
 */
public class StopTest implements Runnable{

    /***
     * 设置一个标志位
     */
    private boolean flag = true;

    @Override
    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run----Thread" + i++);
        }
    }

    /**
     * 设置一个公开的方法停止线程，转换标志位
     */
    public void stopMy(){
        this.flag = false;
    }

    public static void main(String[] args) {
        StopTest stopTest = new StopTest();
        new Thread(stopTest).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("main" + i);
            if (i == 900){
                //调用此方法切换标志位，让线程停止
                stopTest.stopMy();
                System.out.println("线程该停止了");
            }
        }
    }
}
