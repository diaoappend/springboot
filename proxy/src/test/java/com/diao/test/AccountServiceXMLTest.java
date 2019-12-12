package com.diao.test;

import com.diao.domain.Account;
import com.diao.service.IAccountService;
import com.diao.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceXMLTest {
    @Test
    public void testFindAll(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        IAccountService as = (AccountServiceImpl)ac.getBean("accountService");
        List<Account> resultList = as.findAllAccount();
        for (Account account : resultList) {
            System.out.println(account.toString());
        }
    }
    @Test
    public void testFindAccountById(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        IAccountService as = (AccountServiceImpl)ac.getBean("accountService");
        Account account = as.findAccountByID(2);
        System.out.println(account.toString());
    }
}
