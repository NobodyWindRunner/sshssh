package com.zjr.service;

import com.zjr.entity.Project;
import com.zjr.util.PageList;


public interface ProjectService {
	
	/**
	 * 增
	 */
	int add(Project pro);
	
	/**
	 * 删
	 */
	boolean del(Project pro);
	
	/**
	 * 删(根据id)
	 */
	boolean del(int id);
	
	/**
	 * 改
	 */
	boolean update(Project pro);

	/**
	 * 查
	 */
	Project get(int id);
	
	/**
	 * 列
	 */
	PageList<Project> queryHQLByPage(int page,
                                     int size);
	/**
	 * 历史
	 */
	PageList<Project> queryHisHQLByPage(int page,
                                        int size);
	
	/**
	 * 计
	 */
	Long count();
	
	/**
	 * 重
	 */
	boolean checkName(String proName);

	
}
