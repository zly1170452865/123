package com.yuntu.biz;

import com.yuntu.enetiy.Stuinfo;
import com.yuntu.utli.PageUtil;

import java.util.List;

public interface StuinfoBiz {
    void getPage(PageUtil pageUtil);
    Stuinfo getOne(int id);
    boolean upd(Stuinfo stuinfo);
}
