package com.demo.testthree;

import com.demo.testtwo.Apple;

/***
 * @author S
 */
public interface ApplePredicate {

    /***
     * 测试
     * @param apple 苹果实体
     * @return
     */
    boolean test(Apple apple);
}
