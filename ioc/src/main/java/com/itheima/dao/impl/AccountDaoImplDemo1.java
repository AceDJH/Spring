package com.itheima.dao.impl;

import com.itheima.dao.IAccountDaoDemo1;
import com.itheima.domain.Account;
import com.itheima.service.IAccountServiceDemo1;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/5/10 19:22
 */
@Repository("accountDaoDemo1")
public class AccountDaoImplDemo1 implements IAccountDaoDemo1 {
    @Autowired
    private QueryRunner runner;

    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class), accountId);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name, money) values(?, ?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update("update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete from account where id = ? ", accountId);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
