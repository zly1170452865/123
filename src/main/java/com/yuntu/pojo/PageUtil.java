package com.yuntu.pojo;

import java.util.List;


public class PageUtil<T> {
	//5个属性
	private int pageindex=1;//当前页
	private int pagesize=10;//页面大小，每页的条数
	private int counts=0;//总记录数，总条数
	private int pagecount=0;//总页数
	private List<T> lists;//每页对象的集合
	//get、set
	public int getPageindex() {
		return pageindex;
	}
	public void setPageindex(int pageindex) {
		this.pageindex = pageindex;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	public int getCounts() {
		return counts;
	}
	//再去设置总条数是，一并把总页数也设置了
	public void setCounts(int counts) {
		this.counts = counts;
		if(counts>0){//确保有数据
			if(counts%pagesize==0){//判断是否整除
				pagecount=counts/pagesize;//总页数=总数/页大小
			}else{
				pagecount=(counts/pagesize)+1;//总页数=总数/页大小+1
			}
		}
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public List<T> getLists() {
		return lists;
	}
	public void setLists(List<T> lists) {
		this.lists = lists;
	}






}
