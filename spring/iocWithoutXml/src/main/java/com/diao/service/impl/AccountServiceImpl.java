package com.diao.service.impl;

import com.diao.dao.IAccountDao;
import com.diao.domain.Account;
import com.diao.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("accountService") //通过注解的方式将该类对象注入IOC容器，如果通过XML方式注入，不用加该注解
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;

    public void setAccountDao(IAccountDao accountDao){
        this.accountDao = accountDao;
    }


    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountByID(Integer accountId) {
        return accountDao.findAccountByID(accountId);
    }

    @Override
    public void saveAccount(Account account) {

    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Account account) {
        accountDao.deleteAccount(account);
    }

    @Override
    public void transfer(String sourceName, String targetName, Float mondy) {
        //1.根据名称查询转出账户
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        //2.根据名称查询转入账户
        Account targetAccount = accountDao.findAccountByName(targetName);
        //3.转出账户减钱
        sourceAccount.setMoney(sourceAccount.getMoney()-mondy);
        //4.转入账户加钱
        targetAccount.setMoney(targetAccount.getMoney()+mondy);
        //5.更新转出账户
        accountDao.updateAccount(sourceAccount);
        //6.更新转入账户
        accountDao.updateAccount(targetAccount);
    }
}
