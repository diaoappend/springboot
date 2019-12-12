package com.diao.test;

import com.diao.domain.Account;
import com.diao.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Spring整合Junit的配置
 *      1.导入spring整合junit的jar(坐标)  导入spring-test依赖
 *      2.使用junit提供的注解吧原有的main方法替换成spring提供的(@RunWith)
 *      3.告知Spring的运行器，spring和ioc创建是基于xml还是注解的，并且说明位置。@ContextConfiguration
 *          locations：指定xml文件的位置，加上classpath关键字，表示在类路径下
 *          classes：指定注解类所在的位置
 * 当使用spring5.x版本时，junit要求4.12以上版本
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = config.SpringConfiguration.class)
public class SpringTestWithJunit {
    @Autowired
    private IAccountService as;

    @Test
    public void testFindAll(){
        List<Account> accounts = as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account.toString());
        }
    }
}
