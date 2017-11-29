package com.zjr.service;

import com.zjr.entity.Department;
import com.zjr.util.PageList;

import java.util.List;


public interface DepartmentService {
	
	/**
	 * 增
	 */
	int add(Department department);
	
	/**
	 * 删
	 */
	boolean del(Department department);
	
	/**
	 * 删(根据id)
	 */
	boolean del(int id);
	
	/**
	 * 改
	 */
	boolean update(Department department);

	/**
	 * 查
	 */
	Department get(int id);

	Department getByName(String name);
	/**
	 * 分页列
	 */
	PageList<Department> queryHQLByPage(int page,int size);

	/**
	 * 列
	 */
	List<Department> queryAll();

	/**
	 * 计
	 */
	Long count();

	/**
	 * 重
	 */
	boolean checkName(String name);
}
