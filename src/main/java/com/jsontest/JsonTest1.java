package com.jsontest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.Map;
/***
 * @author
 * @date 2019/10/25 周五
 */
public class JsonTest1 {

    public static void main(String[] args) {
        //json是一种特殊形式的map
        Map<String,String> strMap = new JSONObject();

        /***
         * 取出name4值的过程：
         *      1、先将字符串转化成JSONArray对象
         *      2、取出对象的第一项，JSONObject对象
         *      3、取出name1的值JSONObject对象
         *      4、取出name2的值JSONObject对象
         *      5、取出name4的值value2
         */
        String a = "[{name1:{name2:{name3:'value1',name4:'value2'}}},{}]";
        JSONArray getJsonArray = JSONArray.fromObject(a);
        //   {"name1":{"name2":{"name3":"value1","name4":"value2"}}}
        JSONObject getJsonObj = getJsonArray.getJSONObject(0);
        String result = getJsonObj.getJSONObject("name1").getJSONObject("name2").getString("name4");
        System.out.println(result);
    }
}
