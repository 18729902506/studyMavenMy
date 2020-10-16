package com.threadtest.demo.mdctest;

import org.slf4j.MDC;

/***
 * MDC映射诊断上下文，
 */
public class Test {
    public static void main(String[] args) {
        MDC.get("");
    }
}
