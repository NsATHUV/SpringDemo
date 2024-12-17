package com.xh.service;

import com.xh.dao.impl.StuDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("stuService")
public class StuService {
    @Autowired
    private StuDaoImpl stuDao;

    public StuDaoImpl getStuDao() {
        return stuDao;
    }

    public void setStuDao(StuDaoImpl stuDao) {
        this.stuDao = stuDao;
    }

    public void say() {
        stuDao.say();
    }
}
