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


}
