package com.ss.junit.poi.dto;

import com.ss.junit.poi.annno.PoiExport;

/**
 * Person
 *
 * @author shisong
 * @date 2019/7/12
 */
public class Person {

    @PoiExport(column = "姓名",order = 1)
    private String name;

    @PoiExport(column = "年龄",order = 2)
    private Integer age;

    @PoiExport(column = "性别",order = 3)
    private Integer sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
