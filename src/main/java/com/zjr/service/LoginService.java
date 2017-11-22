package com.zjr.service;

import com.zjr.entity.User;


public interface LoginService {
	
	/**
	 * 登录
	 */
	User login(int id, String password);
}
