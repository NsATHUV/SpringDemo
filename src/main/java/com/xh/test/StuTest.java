package com.xh.test;

import com.xh.dao.stuDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StuTest {
    private static ApplicationContext getContext() {
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void sayTest() {
        ApplicationContext context = getContext();
        stuDao dao = (stuDao) context.getBean("stuDao");
        dao.say();
    }


    @Test
    //测试不同的scope属性的结果，观察地址
    public void scopeTest() {
        ApplicationContext context = getContext();
        stuDao dao = (stuDao) context.getBean("stuDao");
        stuDao dao2 = (stuDao) context.getBean("stuDao");
        stuDao dao3 = (stuDao) context.getBean("stuDao");
        stuDao dao4 = (stuDao) context.getBean("stuDao");
        System.out.println(dao);
        System.out.println(dao2);
        System.out.println(dao3);
        System.out.println(dao4);
    }

}
