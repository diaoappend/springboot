package com.diao.dao;

import com.diao.bean.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Chenzhidiao
 * @date: 2019/12/19 18:57
 * @description:
 * @version: 1.0
 */
@Repository
public interface AccountDao {



    @Select("select * from account")
    public List<Account> findAll();
    @Insert("insert into account(name,money) values(#{name},#{money})")
    public void saveAccount(Account account);
}
