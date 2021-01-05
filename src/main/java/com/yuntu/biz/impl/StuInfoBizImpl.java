package com.yuntu.biz.impl;

import com.yuntu.biz.StuInfoBiz;
import com.yuntu.dao.stuInfo.StuInfoMapper;
import com.yuntu.pojo.PageUtil;
import com.yuntu.pojo.StuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service("stuInfoBiz")
@Transactional
public class StuInfoBizImpl implements StuInfoBiz {
    @Autowired
    @Qualifier("stuInfoMapper")
    StuInfoMapper stuDao;

    public StuInfoMapper getStuDao() {
        return stuDao;
    }

    public void setStuDao(StuInfoMapper stuDao) {
        this.stuDao = stuDao;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
    public void getPage(PageUtil<StuInfo> pageUtil) {
        int counts=stuDao.getCount();
        if (counts>0){
            pageUtil.setCounts(counts);
            if (pageUtil.getPageindex()>pageUtil.getPagecount()){
                pageUtil.setPageindex(pageUtil.getPagecount());
            }
            pageUtil.setLists(stuDao.getPage(pageUtil));
        }else{
            pageUtil.setLists(new ArrayList<StuInfo>());
        }
    }

    @Override
    public int addStuInfo(StuInfo stu) {
        return stuDao.addStuInfo(stu);
    }

    @Override
    public int delStuInfo(int stu_id) {
        return stuDao.delStuInfo(stu_id);
    }

    @Override
    public int updStuInfo(StuInfo stu) {
        return stuDao.updStuInfo(stu);
    }

    @Override
    public StuInfo getOne(int stu_id) {
        return stuDao.getOne(stu_id);
    }
}
