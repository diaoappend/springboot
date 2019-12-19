package com.diao.test;

import com.diao.domain.Account;
import com.diao.service.IAccountService;
import com.diao.service.impl.AccountServiceImpl;
import config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AccountServiceAnnotationTest {

    @Test
    public void testAnnotation(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountService as =(AccountServiceImpl)ac.getBean("accountService");
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
    }

}
