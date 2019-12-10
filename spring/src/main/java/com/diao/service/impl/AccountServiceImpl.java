package com.diao.service.impl;

import com.diao.service.IAccountService;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService {
    public AccountServiceImpl(){

    }
    public void say(){
        System.out.println("this is service instance");
    }
}
