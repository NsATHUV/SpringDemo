package com.xh.servlet;

import com.xh.service.StuService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StuServlet {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        StuService stuService = (StuService) app.getBean("stuService");
        stuService.say();
    }
}
