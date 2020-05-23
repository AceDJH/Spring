package com.djh.service;

import com.djh.domain.Account;

/**
 * @Author AceDJH
 * @Date 2020/5/22 20:55
 * 账户的业务层接口
 */
public interface IAccountService {
    Account findAccountById(Integer accountId);
    /*转账
    * */
    void transfer(String sourceName, String targetName, float money);
}
