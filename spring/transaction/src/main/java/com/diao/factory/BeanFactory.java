package com.diao.factory;

import com.diao.service.IAccountService;
import com.diao.service.impl.AccountServiceImpl;
import com.diao.utils.TransactionUtils;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

public class BeanFactory {
    private IAccountService accountService;
    private TransactionUtils transactionUtils;

    public void setAccountService(IAccountService accountService) {
        this.accountService = accountService;
    }

    public void setTransactionUtils(TransactionUtils transactionUtils) {
        this.transactionUtils = transactionUtils;
    }


    public IAccountService getAccountService() {
        return (IAccountService) Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * 作用：执行被代理对象的任何接口方法都会经过该方法
                     *
                     * @param proxy  代理对象的引用
                     * @param method 当前执行的方法
                     * @param args   当前执行方法的参数
                     * @return 和被代理对象有相同的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //增强的方法，在原有方法的基础上增加事务
                        Object rtValue = null;
                        try {
                            transactionUtils.beginTransaction();
                            rtValue = method.invoke(accountService, args);
                            transactionUtils.commitTransaction();
                            return rtValue;
                        } catch (Exception e) {
                            transactionUtils.rollbackTransaction();
                            e.printStackTrace();
                            throw new RuntimeException();
                        } finally {
                            transactionUtils.endTransaction();
                        }
                    }
                });
    }
}
