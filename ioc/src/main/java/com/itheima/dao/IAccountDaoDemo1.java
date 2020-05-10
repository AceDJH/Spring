package com.itheima.dao;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/5/10 19:08
 * 账户的持久层接口
 */
public interface IAccountDaoDemo1 {
    List<Account> findAllAccount();
    Account findAccountById(Integer accountId);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer accountId);
}
