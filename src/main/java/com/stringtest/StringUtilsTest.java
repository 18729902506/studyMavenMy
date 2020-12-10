package com.stringtest;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

public class StringUtilsTest {

    @Test
    public void test() {
        //true
        System.out.println(StringUtils.isNumeric(""));
        //false
        System.out.println(StringUtils.isNumeric(" "));
        //false
        System.out.println(StringUtils.isNumeric(null));
        //false
        System.out.println(StringUtils.isNumeric("12 3"));

    }

}
