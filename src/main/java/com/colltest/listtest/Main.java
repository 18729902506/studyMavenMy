package com.colltest.listtest;

import java.util.ArrayList;
import java.util.List;
/***
 *  如果想要判断两个对象的值是否相等，需要在实体类中重写该对象类型的equals()方法，
 *  如果想要比较对象的内容，需要使用equals()方法
 *  基本类型的比较，使用的是 ==
 *  ==  和 != 比较的是对象的引用
 *
 *   创建一个对象之后，就会在内存中开辟一块空间，空间里存放的便是对象，
 *   这个空间有个引用也就是对象的地址，通过这个引用就能找到这个对象的内容
 *
 *   创建对象（实例化）后，对象其实就是内存里的地址
 *
 *   对象的内容看不到，只能看到地址
 *
 *   如果打印对象的引用，会默认调用toString()方法
 *
 *   如果打印对象的引用，输出的不是类名+@ +哈希值，则证明重写了teString()方法
 *
 *   重写hashCode()，主要是为了规定对象之间的比较方式，如果把对象存入hash集合，集合就会对 对象的hashCode进行比较，以区分两个对象是否是统一对象
 * @author
 * @date 2019/10/21
 */
public class Main {

    /***
     *list.toString();
     * 这里是调用Object中的方法，它返回的是String类型的数据，类名+@+哈希值的16进制
     */
    public static void main(String[] args) {
        //如果在实体类ListTest1中重写了equals()方法，那么输出的便是  true  true
        List<ListTest1> list = new ArrayList<>();


        ListTest1 test1 = new ListTest1(1,"流星");
        list.add(test1);
        //true
        System.out.println(list.contains(test1));

        ListTest1 test2 = new ListTest1(1,"流星");
        //false
        System.out.println(list.contains(test2));

    }
}
