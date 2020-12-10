package com.jsontest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/***
 * @author  S
 * JsonObject与JsonArray的区别是：前者是以对象的形式，用put
 *                               而后者是以数组的形式，用add向数组中插入一个元素
 */
public class JsonTest0 {
    public static void main(String[] args) {

        //创建JsonObject的第一种方法
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("UserName","ZhuLi");
        jsonObject.put("age","30");
        jsonObject.put("workIn","ALI");
        System.out.println("jsonObject1:"+jsonObject);

        //创建JsonObject的第二种方法
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("UserName","ZhuLi");
        hashMap.put("age","30");
        hashMap.put("workIn","ALI");
        System.out.println("jsonObject2:"+JSONObject.fromObject(hashMap));

        //创建JsonArray的第一种方法
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0,"ZhuLi");
        jsonArray.add(1,"30");
        jsonArray.add(2,"ALI");
        System.out.println("jsonArray1:"+jsonArray);

        //创建JsonArray的第二种方法
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("ZhuLi");
        arrayList.add("30");
        arrayList.add("ALI");
        System.out.println("jsonArray2:"+JSONArray.fromObject(arrayList));

        //如果JSONArray解析一个HashMap，则会将整个对象的放进一个数组的值中
        System.out.println("jsonArray FROM HASHMAP：" + JSONArray.fromObject(hashMap));
    }
}
