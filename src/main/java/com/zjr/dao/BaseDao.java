package com.zjr.dao;

import java.io.Serializable;
import java.util.List;


public interface BaseDao<T> {

	//对象->添加操作->返回当前对象ID
	public int save(T t);
	
	//对象->删除操作->返回成功或失败
	public boolean delete(T t);
	
	//对象->删除操作(id)->返回成功或失败
	public boolean delete(Class<T> cla, Serializable id);

	//对象->更新操作->返回成功或失败
	public boolean update(T t);
	
	//根据ID获取对象
	public T get(Class<T> cla, Serializable id);
	
	//根据HQL获取对象
	public T get(String hql, Object... pras);

	//使用HQL语句查询一条及以上的数据
	public List<T> queryByHQL(String hql, Boolean isCach, Object... pras);
	
	//使用HQL语句查询所有数据列表分页
	public List<T> queryHQLByPage(String hql, Boolean isCach, int page,
                                  int size, Object... pras);
	
	//统计数据总量
	public Long count(String hql, Object... pras);

}
