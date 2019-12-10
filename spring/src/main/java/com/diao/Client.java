package com.diao;


import com.diao.bean.People;
import com.diao.controller.impl.AccountController;
import com.diao.dao.IAccountDao;
import com.diao.service.IAccountService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


public class Client {
    public static void main(String[] args) {
        /**
         * ClassPathXmlApplicationContext:可以加载类路径下的配置文件，必须在类路径
         * FileSystemXmlApplicationContext:可以加载文件系统任意路径下的配置文件
         * AnnotationConfigApplicationContext:用于读取注解配置
         *
         * ApplicationContext:直接创建对象，适用于单例
         * BeanFactory:使用时创建对象，适用于多例
         */
       /* ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        IAccountService as = (IAccountService) ac.getBean("accountService");
        IAccountDao ad = ac.getBean("accountDao", IAccountDao.class);
        System.out.println(as);
        System.out.println(ad);

        Resource resource = new ClassPathResource("beans.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        IAccountService am = (IAccountService)factory.getBean("accountService");
        System.out.println(am);*/


        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        People peo = (People) ac.getBean("people");
        peo.accountController.say();

    }
}
