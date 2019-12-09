package com.diao.dao.impl;

import com.diao.dao.IAccountDao;

public class AccountDaoImpl implements IAccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存成功");
    }
}
