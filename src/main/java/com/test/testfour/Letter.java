package com.test.testfour;

import java.util.function.Function;

public class Letter {

    public static String addHeader(String text){
        return "From Raoul,Mario and Alan:"+text;
    }

    public static String addFooter(String text){
        return text +"Kind regards";
    }

    public static String checkSpelling(String text){
        return text.replaceAll("labda","lambda");
    }

    /***
     * 创建一个转型流水线，先加上抬头，然后进行拼写检查，最后再加上一个落款
     */
    Function<String,String> addHeader = Letter::addHeader;

    Function<String,String> transformationPipeline = addHeader.andThen(Letter::checkSpelling)
                                                              .andThen(Letter::addFooter);








}
