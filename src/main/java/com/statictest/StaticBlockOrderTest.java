package com.statictest;

/***
 * @author s
 * 一个对象的初始化顺序：
 * 先去执行父类里面静态代码块的内容，父类执行完成后，才去执行子类中的静态代码块
 * 接着去执行父类中非静态代码块和父类的构造方法
 * 父类的构造方法完成后，最后执行子类的非静态代码块和构造方法
 *
 * 子类的构造方法，不管这个构造方法带不带参数，默认它都会先去寻找父类的不带参数的构造方法，
 * 如果父类没有不带参数的构造方法，那么子类必须用super关键字来调用父类带参数的构造方法
 *
 * 被static修饰的成员都是类成员
 */
public class StaticBlockOrderTest {
    /***
     *  parent static block
     *  child static block
     *  parent block
     *  parent constructor
     *  child block
     *  child constructor
     * @param args
     */
    public static void main(String[] args) {
//        new Child();
       String a = "400.00";
       //00
        System.out.println(a.substring(a.indexOf(".")+1));
//        string.substring(string.indexOf(".") + 1)
        //400
        System.out.println(a.substring(0,a.indexOf(".")));
    }
}
