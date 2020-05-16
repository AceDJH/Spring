package com.djh.dao.impl;

import com.djh.dao.IAccountDao;
import com.djh.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/5/16 20:08
 */
public class AccountDaoImpl extends JdbcDaoSupport implements IAccountDao {
    public Account findAccountById(Integer accountId) {
        List<Account> list =  super.getJdbcTemplate().query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return list.isEmpty() ? null : list.get(0);
    }

    public Account findAccountByName(String accountName) {
        List<Account> list =  super.getJdbcTemplate().query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (list.isEmpty()){
            return null;
        }
        if (list.size() > 1){
            throw new RuntimeException("结果集不唯一");
        }
        return list.get(0);
    }

    public void updateAccount(Account account) {
        super.getJdbcTemplate().update("update account set name = ? , money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }
}
