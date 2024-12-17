package com.xh.statics;

import com.xh.dao.impl.StuDaoImpl;
import com.xh.dao.StuDao;

public class StaticFactory {
    public static StuDao createStuDao(){
        return new StuDaoImpl();
    }
}
