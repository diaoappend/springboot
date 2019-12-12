package com.diao.dao.impl;

import com.diao.dao.IAccountDao;
import com.diao.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("accountDao")//通过注解方式注入
public class AccountDaoImpl implements IAccountDao {
    @Autowired //加了该注解可以自动注入，下面的set方法就不是必需的了
    private QueryRunner runner;

    /*public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }*/

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Account findAccountByID(Integer accountId) {
        try {
            return runner.query("select * from account where id=?", new BeanHandler<Account>(Account.class),accountId);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try{
            runner.update("insert into account(name,money) values(?,?)",account.getName(),account.getMoney());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try{
            runner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteAccount(Account account) {
        try{
            runner.update("delete from account where id=?",account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * @param accountName
     * @return 找到一个直接返回，没找到返回null，找到大于一个抛异常
     */
    @Override
    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = runner.query("select * from account where name = ? ",new BeanListHandler<Account>(Account.class),accountName);
            if(accounts.size()==0||accounts==null){
                return null;
            }
            if (accounts.size()>1){
                throw new RuntimeException("结果不唯一！");
            }
            return accounts.get(0);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
