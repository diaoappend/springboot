package com.diao.controller;

import com.diao.bean.Account;
import com.diao.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


/**
 * @author: Chenzhidiao
 * @date: 2019/12/19 19:01
 * @description:
 * @version: 1.0
 */
@Controller
public class AccountController {
    @Autowired
    private AccountService accountService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("springmvc测试");
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        accountService.saveAccount(account);
        return "list";
    }
}
