package com.colltest.colltest2;

/***
 * @author shang
 * @date 2019/09/07
 */
public class TestA {
    /**
     * 姓名
     */
    private String name;
    /***
     * 编号
     */
    private Integer id;

    public TestA(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
