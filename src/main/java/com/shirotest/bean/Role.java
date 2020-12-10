package com.shirotest.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Set;

/***
 * @author s
 */
@Data
@ApiModel
@AllArgsConstructor
public class Role {

    private String id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "角色对应的权限集合")
    private Set<Permissions> permissions;
}
