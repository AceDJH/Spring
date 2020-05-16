package com.djh.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @Author AceDJH
 * @Date 2020/5/16 19:57
 * JDBCtemplate的最基本用法
 */
public class jdbcTemplate {
    public static void main(String[] args) {
        // 准备数据源
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("123");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.execute("insert into account(name, money) values('ddd', 1000)");
    }
}
