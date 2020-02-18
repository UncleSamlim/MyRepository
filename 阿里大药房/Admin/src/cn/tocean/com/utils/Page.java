package cn.tocean.com.utils;

import java.util.List;

public class Page<T> {
	private int currentPage;//当前页码  前端传进来的，手工赋值
	private int pageSize;//每页大小  手工赋值
	private int count;//按条件查询出的总记录数     按条件 查询数据库得到的
	private int totalPages;//总页数   计算
	private List<T> list; //每页的记录详细信息      按条件 查询数据库得到的
	public int getTotalPages() {
		totalPages = count/pageSize;
		if (count%pageSize!=0) {
			totalPages = totalPages + 1;
		}
		return totalPages;
	}
	public Page() {
		super();
	}
	public Page(int currentPage, int pageSize, int count, 
			List<T> list) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.count = count;
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
}
