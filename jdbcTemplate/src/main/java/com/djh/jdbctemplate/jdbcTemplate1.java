package com.djh.jdbctemplate;

import com.djh.dao.IAccountDao;
import com.djh.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @Author AceDJH
 * @Date 2020/5/16 19:57
 * JDBCtemplate的最基本用法
 */
public class jdbcTemplate1 {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        IAccountDao accountDao = applicationContext.getBean("accountDao", IAccountDao.class);

        Account account = accountDao.findAccountById(1);
        account.setMoney((float) 5000);
        accountDao.updateAccount(account);
        System.out.println(account.toString());
    }
}
