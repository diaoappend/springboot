package com.diao.service.impl;

import com.diao.dao.IAccountDao;
import com.diao.domain.Account;
import com.diao.service.IAccountService;
import com.diao.utils.TransactionUtils;

import java.util.List;

//@Service("accountService_old") //通过注解的方式将该类对象注入IOC容器，如果通过XML方式注入，不用加该注解
public class AccountServiceImpl_old implements IAccountService {

    private IAccountDao accountDao;

    private TransactionUtils transactionUtils;

    public void setTransactionUtils(TransactionUtils transactionUtils) {
        this.transactionUtils = transactionUtils;
    }


    public void setAccountDao(IAccountDao accountDao){
        this.accountDao = accountDao;
    }


    @Override
    public List<Account> findAllAccount() {
        try {
            //开启事务
            transactionUtils.beginTransaction();
            //执行操作
            List<Account> accounts = accountDao.findAllAccount();
            //提交事务
            transactionUtils.commitTransaction();
            return accounts;
        }catch (Exception e){
            //回滚事务
            transactionUtils.rollbackTransaction();
            e.printStackTrace();
            throw new RuntimeException();
        }finally {
            //断开连接
            transactionUtils.endTransaction();
        }

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
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            transactionUtils.beginTransaction();
            //1.根据名称查询转出账户
            Account sourceAccount = accountDao.findAccountByName(sourceName);
            //2.根据名称查询转入账户
            Account targetAccount = accountDao.findAccountByName(targetName);
            //3.转出账户减钱
            sourceAccount.setMoney(sourceAccount.getMoney()-money);
            //4.转入账户加钱
            targetAccount.setMoney(targetAccount.getMoney()+money);
            //5.更新转出账户
            accountDao.updateAccount(sourceAccount);
            int i = 1/0;
            //6.更新转入账户
            accountDao.updateAccount(targetAccount);
            transactionUtils.commitTransaction();

        }catch (Exception e){
            transactionUtils.rollbackTransaction();
            e.printStackTrace();
        }finally {
            transactionUtils.endTransaction();
        }

    }
}
