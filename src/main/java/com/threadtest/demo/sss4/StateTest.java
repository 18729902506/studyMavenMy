package com.threadtest.demo.sss4;

public class StateTest {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() ->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("//////");
        });


        //观察状态
        Thread.State state = thread.getState();
        //NEW
        System.out.println(state);

        //观察启动后
        //启动线程
        thread.start();
        state = thread.getState();
        //Runnable
        System.out.println(state);

        while (state != Thread.State.TERMINATED){
            Thread.sleep(100);
            //更新线程状态
            state = thread.getState();
            //输出状态   TERMINATED
            System.out.println(state);
        }

        //语句会报错，因为死亡之后的线程就不能在启动了
        thread.start();
    }
}
