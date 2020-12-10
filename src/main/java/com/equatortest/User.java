package com.equatortest;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/***
 * 实体类
 * @author
 */
@Data
@ApiModel
public class User {
    private Integer id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
