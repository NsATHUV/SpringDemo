package com.xh.dao.impl;

import com.xh.dao.StuDao;
import org.springframework.stereotype.Repository;

@Repository("stuDao")
public class StuDaoImpl implements StuDao {

    @Override
    public void say() {
        System.out.println("好想玩GTA:VI !");
    }

    @Override
    public void sayToSomeone(String name) {
        System.out.println("你好，" + name);
    }
}
