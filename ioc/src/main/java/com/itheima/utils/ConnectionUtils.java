package com.itheima.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author AceDJH
 * @Date 2020/5/14 15:17
 */

@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();

    @Autowired
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // 获得当前线程上的连接
    public Connection getThreadConnection(){
        // 先从ThreadLocal上获取
        Connection conn = threadLocal.get();
        if (conn == null){
            try {
                conn = dataSource.getConnection();
                threadLocal.set(conn);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }

    public void removeConnection(){
        threadLocal.remove();
    }
}
