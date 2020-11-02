package com.threadtest.demo.methodtest;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

/***
 * @author shang
 * @date 2020-10-22
 * 队列：排队，
 * 通常是以FIFO，先进先出的排序方式排序各个元素，不过优先级队列或者堆栈队列(LIFO)排除
 * 队列的头都是调用remove()或者poll()来移除元素，
 * 在先进先出的队列中，所有的新元素都是插入队列的末尾
 */
public class QueueTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void offerOrAdd(){
        //限定容量的queue
        Queue<String> queue = new LinkedBlockingDeque<>(2);
        Assert.assertTrue(queue.offer("a"));
        Assert.assertTrue(queue.offer("b"));
        //超过队列容量时offer()返回false
        Assert.assertFalse(queue.offer("c"));
        Assert.assertEquals(2, queue.size());

        //验证预期的异常，使用JUint框架中的ExpectedException类
        thrown.expect(RuntimeException.class);
        Queue<String> queue2 = new LinkedBlockingDeque<>(1);
        Assert.assertTrue(queue2.add("a"));
        //超过队列容量时add()会报IllegalStateException异常
        queue2.add("b");
    }

    @Test
    public void testBoxingClass() {
        //true false false false
        Integer c = 50;
        //转化为Integer类型的值
        Integer d = Integer.valueOf(50);
        System.out.println(c == d);

        //封装类的构造器
        Integer e = new Integer(50);
        Integer f = new Integer(50);
        System.out.println(e == f);

        Integer g = new Integer(50);
        //把封装类对象转化为基本数据类型的值
        Integer h = new Integer(50).intValue();
        System.out.println(g == h);

        Integer i = Integer.valueOf(50);
        Integer j = new Integer(50);
        System.out.println(i == j);
    }

}
