package com.xh.test;

import com.xh.dao.stuDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StuTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        stuDao dao = (stuDao) context.getBean("stuDao");
        dao.say();
    }
}
