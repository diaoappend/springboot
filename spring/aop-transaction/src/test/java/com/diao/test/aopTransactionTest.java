package com.diao.test;

import com.diao.service.IAccountService;
import com.diao.service.impl.AccountServiceImpl;
import com.diao.utils.TransactionUtils;

import org.junit.Test;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public class aopTransactionTest {


    @Test
    public void testTransaction() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        //被代理类的对象
        IAccountService as = (IAccountService) ac.getBean("accountService");
        as.transfer("aaa", "bbb", 100f);
    }

}

