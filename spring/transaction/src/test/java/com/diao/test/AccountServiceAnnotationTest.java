package com.diao.test;

import com.diao.domain.Account;
import com.diao.service.IAccountService;
import com.diao.service.impl.AccountServiceImpl;
import config.SpringConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceAnnotationTest {

    @Test
    public void testAnnotation(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        IAccountService as =(AccountServiceImpl)ac.getBean("accountService");
        as.transfer("aaa","bbb",100f);
    }

}
