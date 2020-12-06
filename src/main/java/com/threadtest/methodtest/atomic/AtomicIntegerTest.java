package com.threadtest.methodtest.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/***
 * java的并发机制：需要去从原子性，有序性，可见性考虑，后两个可以通过synchronized关键字实现
 * AtomicInteger：保证了原子性
 * compareAndSwap   CAS  比较并替换，包含三个操作数，内存位置，预期原值，新值
 * 执行CAS的时候，如果内存位置中的值（自家儿子）与预期原值（预期的媳妇）相比较，如果是匹配的，处理器会自动将该位置的值更新为新值，否则处理器不会做任何操作。
 * @author shang
 * @date 2020-10-26
 */
public class AtomicIntegerTest {
    private static Integer count = 0;

    synchronized public static void incrementTest1(){
        /**
         * count++的操作：
         *    从内存中读取count的值
         *    对count进行加1操作
         *    把count重新刷新到内存中
         * 单线程中没有什么问题，但是多线程中，有的线程将a已经进行了加1操作，但是还没有来得及刷新到内存中，其他线程就已经读取了旧值，因此才会造成错误。
         */
        count++;
    }

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void incrementTest2(){
        //先取的旧值，然后再进行自增
        atomicInteger.getAndIncrement();
    }


}
