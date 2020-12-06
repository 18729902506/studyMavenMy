package com.threadtest.sss;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/***
 * @author shang
 * 联系Thread类，实现多线程同步下载图片
 */
public class ThreadTest2 extends Thread {

    /**
     * 网络图片地址
     */
    private String url;

    /**
     * 保存的文件名
     */
    private String name;

    public ThreadTest2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downLoader(url, name);
        //下载了文件名为：2.svg
        //下载了文件名为：3.svg
        //下载了文件名为：1.svg
        System.out.println("下载了文件名为：" + name);
    }

    public static void main(String[] args) {
        ThreadTest2 t1 = new ThreadTest2("https://www.cnblogs.com/images/aggsite/myblog.svg", "1.svg");
        ThreadTest2 t2 = new ThreadTest2("https://www.cnblogs.com/images/aggsite/myblog.svg", "2.svg");
        ThreadTest2 t3 = new ThreadTest2("https://www.cnblogs.com/images/aggsite/myblog.svg", "3.svg");
        //理想情况下：先下载t1,在下载t2,最后t3，但是并不是，线程是同时执行的，每一次执行的顺序都不一样
        t1.start();
        t2.start();
        t3.start();
    }
}

/***
 * 下载器
 * 将一个链接的URL变成一个文件
 */
class WebDownloader {
    public void downLoader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常，downLoader方法出现问题。");
        }
    }
}
