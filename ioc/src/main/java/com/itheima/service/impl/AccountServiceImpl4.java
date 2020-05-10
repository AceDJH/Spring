package com.itheima.service.impl;

import com.itheima.service.IAccountService;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 账户的业务层实现类
 */
@Component
public class AccountServiceImpl4 implements IAccountService {
    // 如果是经常变化的数据，并不适用于注入的方式
    private String name;
    private Integer age;
    private Date birthday;

    public AccountServiceImpl4() {
    }

    public AccountServiceImpl4(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void  saveAccount(){
        System.out.println("saveAccount执行了" + toString());
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
