package example.serialtest.classtest.blankclasstest;

import java.util.ArrayList;
import java.util.List;

/***
 * 匿名类的测试
 * @author shang
 * 输出结果：三个false
 * list2代表的是一个匿名类的声明和赋值，它定义了一个继承于ArrayList的匿名类，只是没有任何的重写方法而已
 * list3也是一个匿名类，只是多了一个初始化块，起到构造函数的作用，匿名类的构造函数是什么？它么有名字，初始化块就是它的构造函数
 */
public class Test {

    public static void main(String[] args) {
        List list1=new ArrayList();
        List list2=new ArrayList(){};
        List list3=new ArrayList(){{}};
        System.out.println(list1.getClass() == list2.getClass());
        System.out.println(list2.getClass() == list3.getClass());
        System.out.println(list1.getClass() == list3.getClass());
    }
}
