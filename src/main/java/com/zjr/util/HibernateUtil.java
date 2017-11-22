package com.zjr.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class HibernateUtil {
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * @return获取会话工厂对象
	 */
	public SessionFactory getFactory(){
		return sessionFactory;
	}
	
	/**
	 * @return返回会话连接对象
	 */
	 public Session getSession(){
		 Session session = null;
	     try{
	    	 session = sessionFactory.getCurrentSession();
	     }catch (HibernateException e){
	         e.printStackTrace();	            
	         session =sessionFactory.openSession();
	     }
	     return session;
	 }
	
	 public void flush() {
		 getSession().flush();
	 }
	
	/**
	 * 对象->添加操作->返回当前对象ID
	 */
	public int save(Object obj){
		int resu =0;
		Session session = getSession();
		if(obj!=null){
			//执行添加操作 返回当前ID
			resu=(Integer)session.save(obj);
		}else{
			 return 0;
		}
		return  resu;
	}
	
	/**
	 * 对象->删除操作->返回成功或失败
	 */
	public boolean delete(Object obj){
		boolean resu=false;
		Session session = getSession();
		try {
			session.delete(obj);
			resu=true;
		} catch(org.hibernate.ObjectNotFoundException e) {
			return resu;
		}
		return resu;	
	}
	
	/**
	 * 对象->更新操作->返回成功或失败
	 */
	public boolean update(Object obj){
		Session session = getSession();
		try{
			session.update(obj);
		}catch(org.hibernate.ObjectNotFoundException e){
            return false;
        }
		return true;
	}

	
	/**
	 * 根据ID获取对象
	 */
	public <T> T get(Class cla,Serializable id){
		T obj=null;
		Session session = getSession();
		obj=(T)session.get(cla, id);
		return obj;
	}
	
	/**
	 * 根据HQL获取对象列表
	 */
	public <T> List<T> queryHQL(String hql,Boolean isCach,Object...pras){
		List<T> list=new ArrayList<T>();
		Session session=getSession();
			Query query = session.createQuery(hql);
			//设置是否需要将数据保存到缓存中
			query.setCacheable(isCach);
			//判断是否有参数
			if (pras != null) {
				for (int i = 0; i < pras.length; i++) {
					query.setString(i, pras[i].toString());
				}
			}
			list = query.list();
		return list;
	}
	
	/**
	 * 根据HQL获取对象列表并分页
	 */
	public <T> List<T> queryHQLByPage(String hql,Boolean isCach,int page,int size,Object...pras){
		List<T> list=new ArrayList<T>();
		Session session=getSession();
			Query query = session.createQuery(hql);
			query.setCacheable(isCach);
			//判断是否有参数
			if (pras != null) {
				for (int i = 0; i < pras.length; i++) {
					query.setString(i, pras[i].toString());
				}
			}
			//开始记录的行数
			query.setFirstResult((page-1)*size);
			//每页获取的记录数
			query.setMaxResults(size);
			list = query.list();
		return list;
	}

	/**
	 * 根据HQL获取对象
	 */
	public <T> T queryUnique(String hql,Object...pras){
		T obj=null;
		Session session=getSession();
			Query query = session.createQuery(hql);
			//判断是否有参数
			if (pras != null) {
				for (int i = 0; i < pras.length; i++) {
					query.setString(i, pras[i].toString());
				}
			}
			//返回单条数据
			obj=(T)query.uniqueResult();
		return obj;
	}
	
	/**
	 * 返回记录总数
	 */
	public Long getCount(String hql,Object...pras){
		Long count=Long.valueOf("0");
		Session session=getSession();
			Query query = session.createQuery(hql);
			//判断是否有参数
			if (pras != null) {
				for (int i = 0; i < pras.length; i++) {
					query.setString(i, pras[i].toString());
				}
			}
			//返回一行一列的数据
			count=(Long)query.list().get(0);
		return count;
	}
}
