package com.djh.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author AceDJH
 * @Date 2020/5/16 21:41
 * 此类用于抽取DAO的重复代码
 */
public class JdbcDaoSupport {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
