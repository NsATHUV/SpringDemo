package com.xh.service;

import com.xh.dao.StuDao;
import com.xh.dao.impl.StuDaoImpl;

public class StuService {
    private StuDaoImpl stuDao;

    public StuDaoImpl getStuDao() {
        return stuDao;
    }

    public void setStuDao(StuDaoImpl stuDao) {
        this.stuDao = stuDao;
    }

    public void say(){
       stuDao.say();
    }
}
