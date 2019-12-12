package com.diao.bean;

import com.diao.controller.impl.AccountController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("people")
public class People {

    private  String name="zhangsan";

    private int age;
    @Autowired
    public AccountController accountController;

    public People() {
    }

    public People(String name, int age,AccountController accountController ) {
        this.name = name;
        this.age = age;
        this.accountController= accountController;
    }

    @Autowired
    public void sayHello(){
        System.out.println("Hello");
    }


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
}
