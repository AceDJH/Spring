package config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @Author AceDJH
 * @Date 2020/5/10 20:36
 * 该类是一个配置类，作用相当于bean.xml
 *
 */
@Configuration
@ComponentScan(basePackages = "com.itheima")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
