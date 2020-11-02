package com.threadtest.demo.mdctest;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/***
 * @author shang
 * @date 2020-10-26
 */
public class AtomicIntegerTest {
    private static Integer count = 0;

    synchronized public static void incrementTest1(){
        count++;
    }

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void incrementTest2(){
        atomicInteger.getAndIncrement();
    }
}
