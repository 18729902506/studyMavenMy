package com.preconditionstest;

import org.junit.Test;

public class PreconditionsTest1 {

    @Test
    public void Preconditions() throws Exception{
        getPerson(8,"panda");
        getPerson(-9,"panda");
        getPerson(8,"");
        getPerson(8,null);
    }

    public static void getPerson(int age,String name) throws Exception{
        if (age > 0 && name != null && name.isEmpty() != true){
            System.out.println("a person age:"+age+",name:"+name);
        }else{
            System.out.println("参数输入有误！");
        }
    }
}
