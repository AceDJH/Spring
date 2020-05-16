package com.itheima.service.impl;

import com.itheima.dao.IAccountDao;
import com.itheima.dao.IAccountDaoDemo1;
import com.itheima.domain.Account;
import com.itheima.service.IAccountServiceDemo1;
import com.itheima.utils.TransactionManager;
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
    @Autowired
    private TransactionManager transactionManager;

    public List<Account> findAllAccount() {
        try{
            // 1、开启事务
            transactionManager.beginTransaction();
            // 2、执行操作
            List<Account> accounts = accountDao.findAllAccount();
            // 3、提交事务
            transactionManager.commit();
            // 4、返回结果
            return accounts;
        }catch (Exception e){
            // 5、回滚操作
            transactionManager.rollback();
            throw new RuntimeException();
        }finally {
            // 6、释放连接
            transactionManager.release();
        }
    }

    public Account findAccountById(Integer accountId) {
        try{
            // 1、开启事务
            transactionManager.beginTransaction();
            // 2、执行操作
            Account account = accountDao.findAccountById(accountId);
            // 3、提交事务
            transactionManager.commit();
            // 4、返回结果
            return account;
        }catch (Exception e){
            // 5、回滚操作
            transactionManager.rollback();
            throw new RuntimeException();
        }finally {
            // 6、释放连接
            transactionManager.release();
        }
    }

    public void saveAccount(Account account) {
        try{
            // 1、开启事务
            transactionManager.beginTransaction();
            // 2、执行操作
            accountDao.saveAccount(account);
            // 3、提交事务
            transactionManager.commit();
            // 4、返回结果
        }catch (Exception e){
            // 5、回滚操作
            transactionManager.rollback();
        }finally {
            // 6、释放连接
            transactionManager.release();
        }
    }

    public void updateAccount(Account account) {
        try{
            // 1、开启事务
            transactionManager.beginTransaction();
            // 2、执行操作
            accountDao.updateAccount(account);
            // 3、提交事务
            transactionManager.commit();
            // 4、返回结果
        }catch (Exception e){
            // 5、回滚操作
            transactionManager.rollback();
        }finally {
            // 6、释放连接
            transactionManager.release();
        }
    }

    public void deleteAccount(Integer accountId) {
        try{
            // 1、开启事务
            transactionManager.beginTransaction();
            // 2、执行操作
            accountDao.deleteAccount(accountId);
            // 3、提交事务
            transactionManager.commit();
            // 4、返回结果
        }catch (Exception e){
            // 5、回滚操作
            transactionManager.rollback();
        }finally {
            // 6、释放连接
            transactionManager.release();
        }
    }

    public void transfer(String sourceName, String targetName, Float money) {
        try{
            // 1、开启事务
            transactionManager.beginTransaction();
            // 2、执行操作
            Account source = accountDao.findAccountByName(sourceName);
            Account target = accountDao.findAccountByName(targetName);
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);
            accountDao.updateAccount(source);
            // int a = 1/0;
            accountDao.updateAccount(target);
            // 3、提交事务
            transactionManager.commit();
            // 4、返回结果
        }catch (Exception e){
            // 5、回滚操作
            transactionManager.rollback();
        }finally {
            // 6、释放连接
            transactionManager.release();
        }
    }

}
