package com.shirotest.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author s
 */
@Data
@AllArgsConstructor
@ApiModel
public class Permissions {

    private String id;

    @ApiModelProperty(value = "权限名称")
    private String permissionsName;
}
