package com.java8test.funcinter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/***
 * @author
 */
public class FuncInterTest {

    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> results = new ArrayList<>();
        for (T s:list){
            if (p.test(s)){
                results.add(s);
            }
        }
        return results;
    }

    Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();


    public static<T> void forEach(List<T> list, Consumer<T> c){
        for(T i : list){
            c.accept(i);
        }
    }

    /***
     * 将输入对象的信息映射到输出，比如提取苹果的质量，把字符串映射为它的长度
     * @param list
     * @param f
     * @param <T>
     * @param <R>
     * @return
     */
    public static<T,R> List<R> map(List<T> list, Function<T,R> f){
        List<R> result = new ArrayList<>();
        for (T s : list){
            result.add(f.apply(s));
        }
        return result;
    }

    public static void main(String[] args) {
        //lambda是Consume中accept()方法的实现
        forEach(Arrays.asList(1,2,3,5,8,4),(Integer i) -> System.out.println(i));

        //lambda是Function接口的apply()方法的实现
        List<Integer> m = map(Arrays.asList("lambdas","in","action"),(String s) -> s.length());
        //[7,2,6]
        System.out.println(m);
    }

}
