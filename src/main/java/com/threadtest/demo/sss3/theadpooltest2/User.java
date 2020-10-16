package com.threadtest.demo.sss3.theadpooltest2;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class User {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;
}
