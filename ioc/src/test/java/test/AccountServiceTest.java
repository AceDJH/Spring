package test;

import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import com.itheima.service.IAccountServiceDemo1;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.runner.RunWith;
import org.junit.Test;
import java.applet.AppletContext;
import java.util.List;

/**
 * @Author AceDJH
 * @Date 2020/5/10 18:26
 */
public class AccountServiceTest {
    @Test
    public void testFindAll() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountServiceDemo1 accountService = applicationContext.getBean("accountServiceDemo1", IAccountServiceDemo1.class);
        List<Account> accounts = accountService.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testTransfer(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        IAccountServiceDemo1 accountService = applicationContext.getBean("accountServiceDemo1", IAccountServiceDemo1.class);
        accountService.transfer("aaa", "bbb", 300f);
    }
}