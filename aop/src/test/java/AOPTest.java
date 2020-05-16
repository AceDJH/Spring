import com.djh.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author AceDJH
 * @Date 2020/5/16 15:21
 */
public class AOPTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beanZhuJie.xml");
        IAccountService accountService = (IAccountService) applicationContext.getBean("accountService");
        accountService.saveAccount();
        accountService.deleteAccount();
        accountService.updateAccount(1);
    }
}
