package com.djh.dao;

import com.djh.domain.Account;

/**
 * @Author AceDJH
 * @Date 2020/5/16 20:07
 */
public interface IAccountDao {
    Account findAccountById(Integer accountId);
    Account findAccountByName(String accountName);
    void updateAccount(Account account);
}
