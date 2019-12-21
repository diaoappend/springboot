package com.diao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author: Chenzhidiao
 * @date: 2019/12/19 19:01
 * @description:
 * @version: 1.0
 */
@Controller
public class AccountController {
    @RequestMapping("/findAll")
    public String findAll(){
        System.out.println("springmvc测试");
        return "success";
    }
}
