package com.diao.dao;

import com.diao.bean.Account;

import java.util.List;

/**
 * @author: Chenzhidiao
 * @date: 2019/12/19 18:57
 * @description:
 * @version: 1.0
 */
public interface AccountDao {
    public List<Account> findAll();

    public void saveAccount(Account account);
}
