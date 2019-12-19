package com.diao.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: Chenzhidiao
 * @date: 2019/12/17 8:16
 * @description:
 * @version: 1.0
 */
public class User implements Serializable {
    private String name;
    private int age;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

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

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}
