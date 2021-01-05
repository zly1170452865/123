package com.yuntu.biz;

import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.StuInfo;


public interface StuInfoBiz {
    void getPage(PageUtil<StuInfo> pageUtil);

    int addStuInfo(StuInfo stu);

    int delStuInfo(int stu_id);

    int updStuInfo(StuInfo stu);

    StuInfo getOne(int stu_id);
}
