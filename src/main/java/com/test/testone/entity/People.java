package com.test.testone.entity;

import com.test.testone.interfaces.First;
import lombok.Data;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class People {

    /**
     *在First分组时，判断不能为空
     */
    @NotEmpty(groups = {First.class})
    private String id;

    @NotEmpty
    @Size(min = 3,max = 8)
    private String name;//name字段不能为空，且长度在3-8之间
}
