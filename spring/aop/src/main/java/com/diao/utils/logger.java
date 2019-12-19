package com.diao.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 日志记录工具类，提供了公共代码
 */
public class logger {
    public void beforePrint() {
        System.out.println("前置通知");
    }

    public void afterPrint() {
        System.out.println("后置通知");
    }

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
