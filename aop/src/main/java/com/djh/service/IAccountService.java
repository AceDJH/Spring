package com.djh.service;

/**
 * @Author AceDJH
 * @Date 2020/5/16 15:01
 * 账户的业务层接口
 */
public interface IAccountService {
    // 模拟保存账户
    void saveAccount();

    void updateAccount(int i);

    int deleteAccount();
}
