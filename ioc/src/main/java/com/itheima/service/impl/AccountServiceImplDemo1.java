package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.IAccountDaoDemo1;
import com.itheima.domain.Account;
import com.itheima.service.IAccountServiceDemo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/5/10 19:05
 * 账户的业务层实现类
 */
@Service("accountServiceDemo1")
public class AccountServiceImplDemo1 implements IAccountServiceDemo1 {
    @Autowired
    private IAccountDaoDemo1 accountDao;

    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }
}
