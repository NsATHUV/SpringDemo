package com.xh.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xh.bean.StuBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

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
    public void druid_Test() throws SQLException {
        try (DruidDataSource ds = new DruidDataSource()) {
            ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
            ds.setUrl("jdbc:mysql://localhost:3306/test");
            ds.setUsername("root");
            ds.setPassword("123456");
            Connection conn = ds.getConnection();
            System.out.println(conn);
        }
    }
    @Test
    //测试JDBCTemplate
    public void testJDBC() throws PropertyVetoException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.cj.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        ds.setUser("root");
        ds.setPassword("123456");

        //创建JDBCTemplate对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        jdbcTemplate.update("insert into students values(?,?,?)", 1, "张三", 18);
    }

    @Test
    //测试使用Spring配置文件的增删改查
    public void testSpringDB(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        List<StuBean> stu_list =  jdbcTemplate.query("select * from students", new BeanPropertyRowMapper<StuBean>(StuBean.class));

        for (StuBean stu : stu_list) {
            System.out.println(stu);
        }

    }
}
