package com.itheima.ui;

import com.itheima.dao.IAccountDao;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 模拟一个表现层，用于调用业务层
 */
public class Client {
    public static void main(String[] args) {
        //1、 获取核心容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 2、 根据id获取对象
        IAccountService as = (IAccountService) applicationContext.getBean("accountServiceImpl4");
        // IAccountDao adao = applicationContext.getBean("accountDao", IAccountDao.class);
        // System.out.println(adao);
        System.out.println(as);
        as.saveAccount();

    }
}
