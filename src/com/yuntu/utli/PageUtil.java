package com.yuntu.utli;

import java.util.List;

public class PageUtil<T> {
    //1.总条数
    int count;//1.直接从数据库获取
    //2.总页数
    int pageCount;//3.设置页面大小的同时
                 //顺便把值给赋了(只要有总条数和页面大小)
                //获取值的方法,写setPageSize里面
    //3.页面大小;
    int pageSize;//2.设置页面大小
    //4.当前页面
    int pageIndex;//4.从前台页面传入
    //5.当前页数据
    //T放所有类型的集合
    List<T> lists;//5.通过sql语句查询的

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        //算pageCount的值
        //两种情况
        //1.页面总条数与页面大小整除
        //2.页面总条数与页面大小不整除
        if(this.count%this.pageSize==0){
            this.pageCount=this.count/this.pageSize;
        }else{
            this.pageCount=this.count/this.pageSize+1;
        }
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    @Override
    public String toString() {
        return "PageUtil{" +
                "count=" + count +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", lists=" + lists +
                '}';
    }
}
