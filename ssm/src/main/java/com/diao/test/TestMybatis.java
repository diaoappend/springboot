package com.diao.test;

import com.diao.bean.Account;
import com.diao.dao.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;


/**
 * @author: Chenzhidiao
 * @date: 2019/12/23 17:08
 * @description:
 * @version: 1.0
 */
public class TestMybatis {
    @Test
    public void mybatisTest() throws Exception{
        //加载主配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SQLSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //创建SqlSession对象
        SqlSession session = factory.openSession();
        //获取到代理对象
        AccountDao dao = session.getMapper(AccountDao.class);
        //查询所有数据
        /*List<Account> all = dao.findAll();
        for (Account account : all) {
            System.out.println(account.toString());
        }*/
        dao.saveAccount(new Account(3,"wangwu",45687.0));

        session.commit();
        //关闭资源
        session.close();
        in.close();
    }
}
