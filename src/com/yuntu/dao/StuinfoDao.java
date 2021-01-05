package com.yuntu.dao;

import com.yuntu.enetiy.Stuinfo;
import com.yuntu.utli.PageUtil;

import java.util.List;

public interface StuinfoDao {
    List<Stuinfo> getPage(PageUtil pageUtil);
    int getCount();
    Stuinfo getOne(int id);
    boolean upd(Stuinfo stuinfo);
}
