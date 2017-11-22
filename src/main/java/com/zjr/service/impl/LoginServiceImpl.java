package com.zjr.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zjr.dao.BaseDao;
import com.zjr.entity.User;
import com.zjr.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private BaseDao<User> dao;
	
	@Override
	public User login(int id,String password) {
		// TODO Auto-generated method stub
		return dao.get("from User where id=? and password=?", id,password);
	}
}
