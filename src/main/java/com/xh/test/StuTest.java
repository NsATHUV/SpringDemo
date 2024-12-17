package com.xh.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xh.dao.StuDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;

public class StuTest {
    private static ApplicationContext getContext() {
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void sayTest() {
        ApplicationContext context = getContext();
        StuDao dao = (StuDao) context.getBean("stuDao");
        dao.say();
    }


    @Test
    //测试不同的scope属性的结果，观察地址
    public void scopeTest() {
        ApplicationContext context = getContext();
        StuDao dao = (StuDao) context.getBean("stuDao");
        StuDao dao2 = (StuDao) context.getBean("stuDao");
        StuDao dao3 = (StuDao) context.getBean("stuDao");
        StuDao dao4 = (StuDao) context.getBean("stuDao");
        System.out.println(dao);
        System.out.println(dao2);
        System.out.println(dao3);
        System.out.println(dao4);
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

}
