package com.diao;

import com.diao.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("aop-annotation.xml");
        IAccountService as =(IAccountService)ac.getBean("accountService");
        as.saveAccount();
    }
}
