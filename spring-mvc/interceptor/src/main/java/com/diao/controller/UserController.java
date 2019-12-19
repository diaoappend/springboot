package com.diao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Chenzhidiao
 * @date: 2019/12/19 9:23
 * @description:
 * @version: 1.0
 */
@Controller
public class UserController {
    @RequestMapping("/testInterceptor")
    public String testInterceptor()  {
        System.out.println("testInterceptor执行了。。");

        return "success";
    }
}
