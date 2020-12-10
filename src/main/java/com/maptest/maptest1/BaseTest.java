package com.maptest.maptest1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/***
 * @author shang
 * @date 2019/09/07
 * 向map集合中添加key为key，value为value的元素，当添加成功时返回null，否则返回value
 * Map集合中的key是不能重复的，这就类似于set集合中元素不能重复，但是Map集合中的value是可以重复的
 */
public class BaseTest {

    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("1","demo1");
        //{1=demo1}
        System.out.println("当前map集合中的所有的元素："+map);
        //null  {1=demo1,2=demo1}
        Object put = map.put("2", "demo1");
        System.out.println("添加key为2，value为demo1时的返回值是："+put+"\r\n此时map集合中的所有元素："+map);
        //demo1   {1=demo2,2=demo1}
         put = map.put("1", "demo2");
        System.out.println("添加key为1，value为demo2时的返回值是："+put+"\r\n此时map集合中的所有的元素："+map);

        Object o = map.get("1");
        //demo2
        System.out.println("o"+o);
        boolean b = map.containsKey("1");
        System.out.println("map集合中是否包含Key为1的元素："+b);
        b = map.containsKey("5");
        System.out.println("map集合中是否包含Key5的元素："+b);

        Set set = map.entrySet();
        //set[1=demo2,2=demo1]
        System.out.println("set"+set);

        Map map1 = new HashMap();
        Map map2 = new HashMap();
        map1.put("1","demo1");
        map1.put("2","demo2");
        map2.put("3","test1");
        map2.put("4","test2");
        //{1=demo1,2=demo2}
        System.out.println("添加map2集合前，map1集合中的所有元素："+map1);
        //{3=test1,4=test2}
        System.out.println("map2集合中的所有元素："+map2);

        //putAll方法，往map集合中添加指定集合的所有元素{1=demo1,2=demo2,3=test1,4=test2}
        map1.putAll(map2);
        System.out.println("添加map2集合后，map1集合中的所有元素："+map1);
    }
}
