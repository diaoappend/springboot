package com.diao.service.impl;

import com.diao.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {


    @Override
    public void saveAccount() {
        System.out.println("保存账户");
    }

    @Override
    public void updateAccount(int id) {
        System.out.println("更新账户");
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除账户");
        return 1;
    }
}
