package com.streatest.testone;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 * @author shang
 * @date 2020-09-11
 * Function是一个接口，java8允许在接口中加入具体的方法，接口中的具体方法有两种：default()方法 和 identity()方法
 * identity()方法就是function接口中一个静态方法
 * 测试Function.identity()方法的作用
 */
public class FunctionTest {

    /***
     * 将stream转换成容器或者Map
     * identity()是Function接口的一个静态方法，返回一个输出跟输入一样的lambda表达式对象，等价于形如 t -> t形式的lambda表达式
     */
    @Test
    public void funTest(){
        Stream<String> strTest = Stream.of("I","Love","You","Too");
        //{Too=3, Love=4, I=1, You=3}
        Map<String, Integer> map = strTest.collect(Collectors.toMap(Function.identity(), String::length));
//        Map<String, Integer> map1 = strTest.collect(Collectors.toMap(t ->t,String::length));
        System.out.println(map);
//        System.out.println(map1);
    }

    @Test
    public void testDifference(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        //这样写是没有什么问题，可以运行成功
        int[] ints = list.stream().mapToInt(i -> i).toArray();
        //下面这样写，就会报错，因为mapToInt()的参数需要ToIntFunction参数类型，而ToIntFunction与Function是没有什么关系的
//        list.stream().mapToInt(Function.identity()).toArray();
    }

}
