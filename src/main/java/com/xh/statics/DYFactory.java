package com.xh.statics;
import com.xh.dao.impl.StuDaoImpl;
import com.xh.dao.StuDao;

public class DYFactory {
    public StuDao createStuDao(){
        return new StuDaoImpl();
    }
}
