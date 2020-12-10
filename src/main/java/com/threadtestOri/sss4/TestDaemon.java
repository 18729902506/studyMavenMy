package com.threadtestOri.sss4;

/***
 * 测试守护线程
 * 上帝守护你
 */
public class TestDaemon {

    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        //默认是false，表示用户线程，正常的线程都是用户线程。。。。
        //本来上帝是不会停止的，但是我们把上帝设置成了守护线程，虚拟机不管守护线程，所以上帝是根据你来的，你离开了这个世界，虚拟机停止需要一点时间，跑了一会，发现“你”不见了，上帝这个守护线程也停止了
        thread.setDaemon(true);

        //上帝守护线程启动
        thread.start();

        //用户线程启动
        new Thread(you).start();
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝保佑着你");
        }
    }
}


class You implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都开心的活着");
        }
        System.out.println("good bye world");
    }
}