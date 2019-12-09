package com.diao;


import com.diao.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        IAccountService accountService = (IAccountService)ac.getBean("accountService");
        accountService.saveAccount();
    }
}
