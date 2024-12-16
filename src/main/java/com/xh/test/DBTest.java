package com.xh.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBTest {
    @Test
    public void c3p0_Test() throws PropertyVetoException, SQLException {
        //1.创建数据源
        ComboPooledDataSource ds = new ComboPooledDataSource();
        //设置连接参数
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        ds.setUser("root");
        ds.setPassword("123456");
        //获取连接对象
        Connection conn = ds.getConnection();
        System.out.println(conn);

    }

    @Test
    public void druid_Test() throws PropertyVetoException, SQLException {
        try (DruidDataSource ds = new DruidDataSource()) {
            ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            ds.setUrl("jdbc:mysql://localhost:3306/test");
            ds.setUsername("root");
            ds.setPassword("123456");
            Connection conn = ds.getConnection();
            System.out.println(conn);
        }
    }
}
