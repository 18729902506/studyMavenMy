package com.shirotest.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Set;

/***
 * @author s
 * @date 2019/11/03
 */
@Data
@AllArgsConstructor
@ApiModel
public class User {

    private String id;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty("用户对应的角色集合")
    private Set<Role> roles;
}
