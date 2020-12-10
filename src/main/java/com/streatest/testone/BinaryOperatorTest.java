package com.streatest.testone;

import org.junit.Test;
import java.util.Comparator;
import java.util.function.BinaryOperator;

/***
 * @author shang
 * @date 2020-09-14
 * java Function函数中的 BinaryOperator<>接口用于执行lambda表达式并返回一个类型的返回值
 */
public class BinaryOperatorTest {

    @Test
    public void testBinaryInt(){
        BinaryOperator<Integer> add = (n1 ,n2) -> n1 + n2;
        BinaryOperator<Integer> add2 = Integer::sum;
        //返回7，apply()方法用于接收参数，并返回BinaryOperator中的Integer类型
        System.out.println(add.apply(3,4));
    }

    @Test
    public void testBinaryString(){
        BinaryOperator<String> addStr = (n1, n2) -> n1 + "=====" + n2;
        //返回3=====4，apply()方法用于接收参数，并返回BinaryOperator中的String类型
        System.out.println(addStr.apply("3","4"));
    }

    @Test
    public void testMinBy(){
        BinaryOperator<Integer> bi = BinaryOperator.minBy(Comparator.naturalOrder());
        //返回2，自然排序，然后获取最小的值
        System.out.println(bi.apply(3,2));
    }

    @Test
    public void testMaxBy(){
        BinaryOperator<Integer> bi = BinaryOperator.maxBy(Comparator.naturalOrder());
        //返回3，自然排序，然后获取最大的值
        System.out.println(bi.apply(3,2));
    }
}
