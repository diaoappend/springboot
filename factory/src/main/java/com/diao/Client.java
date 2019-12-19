package com.diao;

import com.diao.factory.BeanFactory;
import com.diao.service.IAccountService;

public class Client {
    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            IAccountService iAccountService = (IAccountService) BeanFactory.getBean("accountService");
            System.out.println(iAccountService);
        }
        //iAccountService.saveAccount();
    }
}
