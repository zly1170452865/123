package com.yuntu.biz.impl;

import com.yuntu.biz.StuinfoBiz;
import com.yuntu.dao.StuinfoDao;
import com.yuntu.dao.StuinfoDao2;
import com.yuntu.dao.impl.StuinfoDaoImpl;
import com.yuntu.dao.impl.StuinfoDaoImpl2;
import com.yuntu.enetiy.Stuinfo;
import com.yuntu.utli.PageUtil;

import java.util.ArrayList;

public class StuinfoBizImpl implements StuinfoBiz {
    StuinfoDao2 dao = null;
    public StuinfoBizImpl(){
        dao = new StuinfoDaoImpl2();
    }
    @Override
    public void getPage(PageUtil pageUtil) {
        int count = dao.getCount();//拿到总条数
        if(count>0){
            pageUtil.setCount(count);//把总条数给赋值
            pageUtil.setPageSize(5);
            //右边界
            if (pageUtil.getPageIndex()>pageUtil.getPageCount()){
                pageUtil.setPageIndex(pageUtil.getPageCount());
            }
            //左边界
            if (pageUtil.getPageIndex()<=1){
                pageUtil.setPageIndex(1);
            }
            pageUtil.setLists(dao.getPage(pageUtil));
        }else {
            pageUtil.setLists(new ArrayList());
        }
    }

    @Override
    public Stuinfo getOne(int id) {
        return dao.getOne(id);
    }

    @Override
    public boolean upd(Stuinfo stuinfo) {
        return dao.upd(stuinfo);
    }
}
