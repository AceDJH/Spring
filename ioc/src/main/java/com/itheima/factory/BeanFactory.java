package com.itheima.factory;

import com.itheima.service.IAccountService;
import com.itheima.service.IAccountServiceDemo1;
import com.itheima.utils.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author AceDJH
 * @Date 2020/5/14 21:00
 * 用于创建Service的代理对象的工厂
 */
@Component("beanFactory")
public class BeanFactory {
    @Autowired
    private IAccountServiceDemo1 accountService;
    @Autowired
    private TransactionManager transactionManager;

    public IAccountServiceDemo1 getAccountService(){
        Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
            // 添加事务的支持
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtValue = null;
                        try{
                            // 1、开启事务
                            transactionManager.beginTransaction();
                            // 2、执行操作
                            rtValue = method.invoke(accountService, args);
                            // 3、提交事务
                            transactionManager.commit();
                            // 4、返回结果
                            return rtValue;
                        }catch (Exception e){
                            // 5、回滚操作
                            transactionManager.rollback();
                            throw new RuntimeException();
                        }finally {
                            // 6、释放连接
                            transactionManager.release();
                        }
                    }
                });
        return accountService;
        }
}
