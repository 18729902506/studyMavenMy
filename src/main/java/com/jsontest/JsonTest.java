package com.jsontest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @author
 * @date 2019/10/25 周五
 */
public class JsonTest {

    public static void main(String[] args) {

        //创建一个JSONObject对象
        JSONObject jsonObject = new JSONObject();
        //JSONObject对象中添加键值对
        jsonObject.put("key1","value1");
        jsonObject.put("key2","value2");
        jsonObject.put("key3","value3");
        System.out.println("jsonObject:"+jsonObject);

        //创建一个JSONArray对象
        JSONArray jsonArray = new JSONArray();
        //将JSONObject对象添加到Json数组中
        jsonArray.add("value1");
        jsonArray.add("value2");
        jsonArray.add("value3");
        System.out.println("jsonArray:"+jsonArray);

        //Map转化为JSONObject
        Map<String,String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        System.out.println("jsonObject2:"+JSONObject.fromObject(map));

        //List转化为JSONArray
        List<String> list = new ArrayList<>();
        list.add("value1");
        list.add("value2");
        list.add("value2");
        System.out.println("jsonArray2:"+JSONArray.fromObject(list));

        //JsonArray解析map，会将整个json对象放进数组
        System.out.println("jsonArray from map:"+JSONArray.fromObject(map));

        //将JSONObject放入JsonArray
        JSONObject jsonObject3 = new JSONObject();
        jsonObject3.put("姓名","张三");
        jsonObject3.put("年龄","13");
        jsonObject3.put("身高","166");
        System.out.println("将JSONObject放入JsonArray:"+JSONArray.fromObject(jsonObject3));
    }
}
