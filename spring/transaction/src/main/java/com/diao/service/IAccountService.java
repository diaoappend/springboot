package com.diao.service;

import com.diao.domain.Account;

import java.util.List;

public interface IAccountService {
    List<Account> findAllAccount();

    Account findAccountByID(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Account account);
    //转账
    void transfer(String sourceName, String targetName, Float mondy);

}
