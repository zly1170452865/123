package com.yuntu.dao.impl;

import com.yuntu.dao.StuinfoDao;
import com.yuntu.dao.StuinfoDao2;
import com.yuntu.enetiy.Stuinfo;
import com.yuntu.utli.BaseDao;
import com.yuntu.utli.PageUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StuinfoDaoImpl2 extends BaseDao implements StuinfoDao2 {
    @Override
    public List<Stuinfo> getPage(PageUtil pageUtil) {
        String sql = "SELECT * FROM stuinfo LIMIT ?,?";
        Object[] params = {(pageUtil.getPageIndex()-1)*pageUtil.getPageSize(),pageUtil.getPageSize()};
        rs = executeSql(sql,params);
        List<Stuinfo> list = new ArrayList<Stuinfo>();
        try {
            while (rs.next()){
                Stuinfo user = new Stuinfo(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                );
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return list;
    }

    @Override
    public int getCount() {
        String sql = "SELECT count(1) from stuinfo";
        Object[] params = {};
        rs=executeSql(sql,params);
        int count = 0;
        try {
            if (rs.next()){
                count = rs.getInt("count(1)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return count;
    }

    @Override
    public Stuinfo getOne(int id) {
        String sql = "SELECT * FROM stuinfo where stu_id=?";
        Object[] params = {id};
        rs = executeSql(sql,params);
        Stuinfo easyBuy_news = null;
        try {
            while (rs.next()){
                easyBuy_news = new Stuinfo( rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return easyBuy_news;
    }

    @Override
    public boolean upd(Stuinfo stuinfo) {
        String slq = "update stuinfo set stu_name=?,stu_pawd=?,stu_sex=?,stu_age=?,stu_address=?,stu_major=? where stu_id=?";
        Object[] params = {stuinfo.getStu_name(),stuinfo.getStu_pwd(),stuinfo.getStu_sex(),stuinfo.getStu_age(),stuinfo.getStu_address(),
                stuinfo.getStu_major(),stuinfo.getStu_id()};
        int count = executUpdate(slq,params);
        if (count>0){
            return true;
        }
        return false;
    }
}
