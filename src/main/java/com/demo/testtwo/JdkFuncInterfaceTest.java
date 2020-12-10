package com.demo.testtwo;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

/***
 * 测试JDK java.util.function包下的函数式接口
 * @author shang
 * @date 2020-09-10
 */
public class JdkFuncInterfaceTest {

    @Test
    public void testPredicate() {
        List<String> listOfString = Arrays.asList("a", "", "b");
        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmptyList = filter(listOfString, nonEmptyStringPredicate);
        assertThat(nonEmptyList, contains("a","b"));
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for (T s : list) {
            if (p.test(s)) {
                results.add(s);
            }
        }
        return results;
    }


}
