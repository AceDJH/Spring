package com.djh.service.impl;

import com.djh.service.IAccountService;
import org.springframework.stereotype.Service;

/**
 * @Author AceDJH
 * @Date 2020/5/16 15:06
 */
@Service("accountService")
public class AccountServiceImpl implements IAccountService {
    public void saveAccount() {
        System.out.println("存储");
    }

    public void updateAccount(int i) {
        System.out.println("更新");
    }

    public int deleteAccount() {
        System.out.println("删除");
        return 0;
    }
}
