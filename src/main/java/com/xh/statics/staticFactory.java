package com.xh.statics;

import com.xh.dao.impl.stuDaoImpl;
import com.xh.dao.stuDao;

public class staticFactory {
    public static stuDao createStuDao(){
        return new stuDaoImpl();
    }
}
