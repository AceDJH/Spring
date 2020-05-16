package com.itheima.dao.impl;

import com.itheima.dao.IAccountDaoDemo1;
import com.itheima.domain.Account;
import com.itheima.service.IAccountServiceDemo1;
import com.itheima.utils.ConnectionUtils;
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
    @Autowired
    private ConnectionUtils connectionUtils;

    public List<Account> findAllAccount() {
        try {
            return runner.query(connectionUtils.getThreadConnection(), "select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public Account findAccountById(Integer accountId) {
        try {
            return runner.query(connectionUtils.getThreadConnection(), "select * from account where id = ?", new BeanHandler<Account>(Account.class), accountId);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(), "insert into account(name, money) values(?, ?)", account.getName(), account.getMoney());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(), "update account set name = ?, money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"delete from account where id = ? ", accountId);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts =  runner.query(connectionUtils.getThreadConnection(),"select * from account where name = ?", new BeanListHandler<Account>(Account.class), accountName);
            if (accounts == null || accounts.size() == 0){
                return null;
            }
            if (accounts.size() > 1){
                throw new RuntimeException("结果集不唯一");
            }
            return accounts.get(0);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }
}
