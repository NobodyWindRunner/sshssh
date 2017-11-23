package com.zjr.service;

import com.zjr.entity.Employee;
import com.zjr.util.PageList;


public interface EmployeeService {

	/**
	 * 增
	 */
	int add(Employee employee);

	/**
	 * 删
	 */
	boolean del(Employee employee);

	/**
	 * 删(根据id)
	 */
	boolean del(int id);

	/**
	 * 改
	 */
	boolean update(Employee employee);

	/**
	 * 查
	 */
	Employee get(int id);

	/**
	 * 列
	 */
	PageList<Employee> queryHQLByPage(int page, int size);

	/**
	 * 条列(条:部门id)
	 */
	PageList<Employee> queryHQLForDepByPage(int id,int page, int size);

	/**
	 * 计
	 */
	Long count();
}
