package com.zjr.util;


import java.util.List;


/**
 * @category 分页数据，支持泛型，包含当前页数据、总页数、当前页数、总记录数
 */
public class PageList<T> {
	private int page;//当前页数
	private int total;//总的页数
	private int count;//总的记录数
	private List<T> list;//当前页数据
	
	/**
	 * @param list 当前页数据
	 * @param page 当前页数
	 * @param size 每页数据量
	 * @param count 总的记录数量
	 */
	public PageList(List<T> list,int page,int size,int count){
		this.page=page;
		this.count=count;
		this.list=list;
		this.total=count%size==0?count/size:(count/size)+1;
	}
	
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
