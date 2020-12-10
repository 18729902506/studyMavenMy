package com.test.testone.entity;

import javax.validation.constraints.Min;

/***
 * @author S
 */
public class Girl {

    @Min(value = 18,message = "未成年人不能进入")
    private Integer age;
}
