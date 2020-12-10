package com.threadtestOri.methodtest;

import java.util.HashMap;
import java.util.Map;

/***
 * @author shang
 * getOrDefault()方法，当map集合中有这个key时，就使用这个key值，如果没有，就是用默认值defaultValue
 */
public class MethodTest {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("name","wdmy");
        map.put("age","24");
        map.put("sex","女");
        String name = map.getOrDefault("name", "test");
        //wdmy  map中存在name，获得name对应的value
        System.out.println(name);
        String address = map.getOrDefault("address", "xian");
        //xian  map中不存在address，使用默认值xian
        System.out.println(address);
    }
}
