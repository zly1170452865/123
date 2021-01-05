package com.yuntu.dao.stuInfo;

import com.yuntu.pojo.StuInfo;
import com.yuntu.pojo.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StuInfoMapper {
    int getCount();

    List<StuInfo> getPage(PageUtil<StuInfo> pageUtil);

    int addStuInfo(StuInfo stu);

    int delStuInfo(@Param("stu_id")int stu_id);

    int updStuInfo(StuInfo stu);

    StuInfo getOne(@Param("stu_id") int stu_id);
}
