package com.threadtest.sss2;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

/***
 * @author shang
 * 利用Callable改造下载图片的案例
 * 实现Callable和实现Runnable接口的区别：实现Callable接口，是有返回值的，它的返回值就是重写的call()的返回值
 * 1、实现Callable接口，需要返回值类型
 * 2、重写call方法，需要抛出异常
 * 3、创建目标对象
 * 4、创建执行服务：ExecutorService ser = Executors.newFixedThreadPool(3);
 * 5、提交执行： Future<Boolean> r1 = ser.submit(t1);
 * 6、获取结果：boolean rs1 = r1.get();
 * 7、关闭服务：ser.shutdownNow()
 */
public class TestCallable implements Callable<Boolean> {

    /**
     * 网络图片地址
     */
    private String url;

    /**
     * 保存的文件名
     */
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public Boolean call() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downLoader(url, name);
        //下载了文件名为：2.svg
        //下载了文件名为：3.svg
        //下载了文件名为：1.svg
        System.out.println("下载了文件名为：" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://www.cnblogs.com/images/aggsite/myblog.svg", "1.svg");
        TestCallable t2 = new TestCallable("https://www.cnblogs.com/images/aggsite/myblog.svg", "2.svg");
        TestCallable t3 = new TestCallable("https://www.cnblogs.com/images/aggsite/myblog.svg", "3.svg");
        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        //提交执行
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        //获取结果
        Boolean rs1 = r1.get();
        Boolean rs2 = r2.get();
        Boolean rs3 = r3.get();

        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        //关闭服务
        ser.shutdown();
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
