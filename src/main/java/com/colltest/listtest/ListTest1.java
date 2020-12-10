package com.colltest.listtest;

import java.util.Objects;

/***
 * @author
 * @date 2019/10/21
 */
public class ListTest1 {

    private Integer id;
    private String name;

    public ListTest1(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListTest1 test1 = (ListTest1) o;
        return Objects.equals(id, test1.id) &&
                Objects.equals(name, test1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
