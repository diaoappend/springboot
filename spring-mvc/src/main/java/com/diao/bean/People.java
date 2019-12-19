package com.diao.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Chenzhidiao
 * @date: 2019/12/17 16:24
 * @description:
 * @version: 1.0
 */
public class People implements Serializable {
    private String name;
    private int age;
    private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
