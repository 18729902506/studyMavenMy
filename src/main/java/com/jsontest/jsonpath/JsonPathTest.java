package com.jsontest.jsonpath;

import com.alibaba.fastjson.JSONPath;
import org.junit.Test;

public class JsonPathTest {

    @Test
    public void testJsonPath(){
        String json = "[{\"path\":\"$.response_code\",\"name\":\"响应码\",\"type\":\"string\"},{\"name\":\"身份证号\",\"path\":\"$.result.small_amount_galaxy_score.id\",\"type\":\"string\"},{\"name\":\"手机号\",\"path\":\"$.result.small_amount_galaxy_score.mobile\",\"type\":\"string\"},{\"name\":\"姓名\",\"path\":\"$.result.small_amount_galaxy_score.name\",\"type\":\"string\"},{\"path\":\"$.result.small_amount_galaxy_score.bj_score\",\"name\":\"星宇分小额版\",\"type\":\"integer\"}]";
        System.out.println(json);

        System.out.println(JSONPath.read(json,"$.name[1]"));
    }
}
