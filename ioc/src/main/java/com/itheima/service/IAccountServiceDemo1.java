package com.itheima.service;

import com.itheima.domain.Account;

import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/5/10 19:01
 * 账户的业务层接口
 */
public interface IAccountServiceDemo1 {
    List<Account> findAllAccount();
    Account findAccountById(Integer accountId);
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer accountId);
    // 转账
    void transfer(String sourceName, String targetName, Float money);
}
