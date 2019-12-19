package com.diao.controller;

import com.diao.exception.SysException;
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
    @RequestMapping("/testException")
    public String testException() throws SysException {
        System.out.println("testException执行了。。");

        try {
            int a=  1/0;
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("捕获异常");
        }

        return "success";
    }
}
