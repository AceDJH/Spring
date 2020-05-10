package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

/**
 * @Author AceDJH
 * @Date 2020/5/8 15:36
 * 模拟一个工厂类（假设存在于jar包）
 */
public class InstanceFactory {
    public IAccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
