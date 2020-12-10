package com.jsontest;

import net.sf.json.JSONObject;

/***
 * @author
 * @date 2019/10/26
 * 总结：put(),accumulate(),element()
 *
 * put()方法，如果jsonObject对象之前存在一个value，在这个key下，当前的value会替换掉之前的value值
 * accumulate()方法，累积value到这个key下，JSONArray将会存储在这个key下来保存所有累积的value，如果key存在，俺么该可用的值时数组
 * element()方法，如果key重复，那么value将直接被覆盖
 */
public class JsonTest2 {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("key1","value1");
        jsonObject.put("key2","value2");
        jsonObject.put("key2","value3");
        jsonObject.put("key4","value4");
        //jsonObject:{"key1":"value1","key2":"value3","key4":"value4"}
        System.out.println("jsonObject:"+jsonObject);

        JSONObject jsonObject1 = new JSONObject();
        jsonObject1.accumulate("key1","value1");
        jsonObject1.accumulate("key2","value2");
        jsonObject1.accumulate("key2","value3");
        jsonObject1.accumulate("key4","value4");
        //jsonObject:{"key1":"value1","key2":["value2","value3"],"key4":"value4"}
        System.out.println("jsonObject:"+jsonObject);

        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.element("key1", "value1");
        jsonObject2.element("key2", "value2");
        jsonObject2.element("key2", "value2");
        jsonObject2.element("key2", "value4");
        //jsonObject:{"key1":"value1","key2":"value4"}
        System.out.println("jsonObject:"+jsonObject2);


    }



}
