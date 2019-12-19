package com.diao.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 日志记录工具类，提供了公共代码
 */
@Component("logger")
@Aspect//表明是一个切面类
public class logger {
    @Pointcut("execution(public void com.diao.service.impl.AccountServiceImpl.saveAccount())")
    private void pt1(){}
    /*@Before("pt1()")
    public void beforePrint() {
        System.out.println("前置通知");
    }
    @AfterReturning("pt1()")
    public void afterPrint() {
        System.out.println("后置通知");
    }
    @AfterThrowing("pt1()")
    public void throwPrint() {
        System.out.println("异常通知");
    }
    @After("pt1()")
    public void finalPrint() {
        System.out.println("最终通知");
    }*/
    @Around("pt1()")
    public Object aroundPoint(ProceedingJoinPoint pjp) {
        Object rtValue = null;
        try {
            Object[] args = pjp.getArgs();//获取业务层切入点方法的参数
            System.out.println("前置通知");
            rtValue = pjp.proceed(args);//明确调用业务层切入点方法
            System.out.println("后置通知");
            return rtValue;
        } catch (Throwable t) {
            System.out.println("异常通知");
            throw new RuntimeException(t);

        } finally {
            System.out.println("最终通知");
        }
    }
}
