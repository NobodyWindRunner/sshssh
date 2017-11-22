package com.zjr.service;

import com.zjr.entity.User;
import com.zjr.util.PageList;


public interface UserService {
	
	/**
	 * 增
	 */
	int add(User user);
	
	/**
	 * 删
	 */
	boolean del(User user);
	
	/**
	 * 删(根据id)
	 */
	boolean del(int id);
	
	/**
	 * 改
	 */
	boolean update(User user);

	/**
	 * 查
	 */
	User get(int id);
	
	/**
	 * 列
	 */
	PageList<User> queryHQLByPage(int page,
                                  int size);
	/**
	 * 计
	 */
	Long count();
}
