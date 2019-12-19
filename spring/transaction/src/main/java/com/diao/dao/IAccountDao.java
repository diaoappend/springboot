package com.diao.dao;

import com.diao.domain.Account;

import java.util.List;

public interface IAccountDao {
    List<Account> findAllAccount();

    Account findAccountByID(Integer accountId);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Account account);

    Account findAccountByName(String accountName);
}
