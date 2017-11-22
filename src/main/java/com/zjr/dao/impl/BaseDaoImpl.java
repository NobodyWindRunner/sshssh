package com.zjr.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjr.dao.BaseDao;
import com.zjr.util.HibernateUtil;


@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

	@Autowired
	private HibernateUtil util;
	
	@Override
	public int save(T t) {
		//对象->添加操作->返回当前对象ID
		return util.save(t);
	}

	@Override
	public boolean delete(T t) {
		if(t!=null) {
			return util.delete(t);
		}
		return false;
	}
	
	@Override
	public boolean delete(Class<T> cla,Serializable id) {
		T t=get(cla, id);
		if(t!=null){
			return util.delete(t);
		}
		return false;
	}	

	@Override
	public boolean update(T t) {
		//对象->更新操作->返回成功或失败
		return util.update(t);
	}

	@Override
	public T get(Class<T> cla, Serializable id) {
		//根据ID获取对象
		return util.get(cla, id);
	}

	@Override
	public T get(String hql, Object... pras) {
		//根据HQL获取对象
		return util.queryUnique(hql, pras);
	}

	@Override
	public List<T> queryByHQL(String hql, Boolean isCach, Object... pras) {
		// TODO Auto-generated method stub
		return util.queryHQL(hql, isCach, pras);
	}
	
	@Override
	public List<T> queryHQLByPage(String hql, Boolean isCach, int page,
			int size, Object... pras) {
		//所有列表,分页
		return util.queryHQLByPage(hql, isCach, page, size, pras);
	}

	@Override
	public Long count(String hql, Object... pras) {
		//统计数据总量
		return util.getCount(hql, pras);
	}

}
