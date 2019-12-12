package com.diao.dao.impl;

import com.diao.dao.IAccountDao;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements IAccountDao {
    @Override
    public void say() {
        System.out.println("this is dao instance!");
    }
}
