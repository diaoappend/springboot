package com.diao.test;

import com.diao.service.IAccountService;
import com.diao.service.impl.AccountServiceImpl;
import com.diao.utils.TransactionUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

public class ProxyTransaction {


    @Test
    public void testTransaction() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        //被代理类的对象
        IAccountService as = (IAccountService) ac.getBean("proxyAccountService");
        as.transfer("aaa", "bbb", 100f);
    }

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //被代理类的对象
        final AccountServiceImpl as = (AccountServiceImpl) ac.getBean("accountService");
        TransactionUtils tu = (TransactionUtils) ac.getBean("transactionUtils");

        IAccountService proxyAccountService = (IAccountService) Proxy.newProxyInstance(as.getClass().getClassLoader(),
                as.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     * @param proxy 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法的参数
                     * @return 和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //增强的方法，这里我们要做的就是判断执行的方法是否是转账，如果是，使用事务
                        Object rtValue = null;
                        if ("transfer".equals(method.getName())) {
                            try {
                                tu.beginTransaction();
                                rtValue = method.invoke(as, args);
                                tu.commitTransaction();
                            } catch (Exception e) {
                                tu.rollbackTransaction();
                            } finally {
                                tu.endTransaction();
                            }
                        }
                        return rtValue;
                    }
                });
        proxyAccountService.transfer("aaa", "bbb", 100f);
    }
}

