package com.zjr.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zjr.dao.BaseDao;
import com.zjr.entity.User;
import com.zjr.service.UserService;
import com.zjr.util.PageList;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private BaseDao<User> dao;
	
	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}

	@Override
	public boolean del(User user) {
		// TODO Auto-generated method stub
		return dao.delete(user);
	}
	
	@Override
	public boolean del(int id) {
		// TODO Auto-generated method stub
		return dao.delete(User.class,id);
	}
	
	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return dao.update(user);
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return dao.get(User.class, id);
	}

	@Override
	public PageList<User> queryHQLByPage( int page,
			int size) {
		List<User> list=dao.queryHQLByPage("from User order by id desc", false, page, size);
		// 防止获取到当前页面的数据为刚刚那条数据的那一页，而导致没有数据，这里做判断
		if (list.size() == 0 && page > 1) {
			page = page - 1;// 返回上一页数据
			list = dao.queryHQLByPage("from User order by id desc", false,page, size);	
		}
		int count = dao.count("select count(id) from User").intValue();
		return new PageList<User>(list, page, size, count);
	}
	
	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return dao.count("select count(id) from User");
	}


	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		User user=dao.get("from User where loginName=?", name);
		return user!=null;
	}

	@Override
	public PageList<User> queryByName(String loginName, int page, int size) {
		List<User> list=dao.queryHQLByPage("from User where loginName like '%"+loginName+"%' order by id desc", false, page, size);
		if(list.size()==0&&page>1){
			page=page-1;
			list=dao.queryHQLByPage("from User where loginName like '%"+loginName+"%' order by id desc", false, page, size);
		}
		int count=dao.count("select count(id) from User where loginName like '%"+loginName+"%' order by id desc").intValue();
		return new PageList<User>(list, page, size, count);
	}
}
