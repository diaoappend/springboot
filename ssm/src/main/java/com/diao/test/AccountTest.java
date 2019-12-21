package com.diao.test;

import com.diao.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Chenzhidiao
 * @date: 2019/12/19 19:27
 * @description:
 * @version: 1.0
 */
public class AccountTest {
    @Test
    public void findAllTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        AccountServiceImpl accountService = (AccountServiceImpl)context.getBean("accountService");
        accountService.findAll();
    }
}
