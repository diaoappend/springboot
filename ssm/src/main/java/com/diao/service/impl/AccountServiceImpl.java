package com.diao.service.impl;

import com.diao.bean.Account;
import com.diao.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Chenzhidiao
 * @date: 2019/12/19 19:20
 * @description:
 * @version: 1.0
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有账户");
        return null;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存账户信息");
    }
}
