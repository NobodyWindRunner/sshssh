package com.zjr.service.impl;

import com.zjr.dao.BaseDao;
import com.zjr.entity.Employee;
import com.zjr.service.EmployeeService;
import com.zjr.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private BaseDao<Employee> dao;
	
	@Override
	public int add(Employee department) {
		// TODO Auto-generated method stub
		return dao.save(department);
	}

	@Override
	public boolean del(Employee department) {
		// TODO Auto-generated method stub
		return dao.delete(department);
	}
	
	@Override
	public boolean del(int id) {
		// TODO Auto-generated method stub
		return dao.delete(Employee.class,id);
	}
	
	@Override
	public boolean update(Employee department) {
		// TODO Auto-generated method stub
		return dao.update(department);
	}

	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		return dao.get(Employee.class, id);
	}

	@Override
	public PageList<Employee> queryHQLByPage( int page, int size) {
		List<Employee> list=dao.queryHQLByPage("from Employee order by id desc", false, page, size);
		// 防止获取到当前页面的数据为刚刚那条数据的那一页，而导致没有数据，这里做判断
		if (list.size() == 0 && page > 1) {
			page = page - 1;// 返回上一页数据
			list = dao.queryHQLByPage("from Employee order by id desc", false,page, size);
		}
		int count = dao.count("select count(id) from Employee").intValue();
		return new PageList<Employee>(list, page, size, count);
	}

	@Override
	public PageList<Employee> queryHQLForDepByPage(int id, int page, int size) {
		List<Employee> list=dao.queryHQLByPage("from Employee where deptId="+id+"order by id desc", false, page, size);
		// 防止获取到当前页面的数据为刚刚那条数据的那一页，而导致没有数据，这里做判断
		if (list.size() == 0 && page > 1) {
			page = page - 1;// 返回上一页数据
			list = dao.queryHQLByPage("from Employee where deptId="+id+"order by id desc", false,page, size);
		}
		int count = dao.count("select count(id) from Employee where deptId="+id).intValue();
		return new PageList<Employee>(list, page, size, count);
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return dao.count("select count(id) from Employee");
	}

	@Override
	public PageList<Employee> queryByName(String name, int page, int size) {
		List<Employee> list=dao.queryHQLByPage("from Employee where name like '%"+name+"%' order by id desc", false, page, size);
		if(list.size()==0&&page>1){
			page=page-1;
			list=dao.queryHQLByPage("from Employee where name like '%"+name+"%' order by id desc", false, page, size);
		}
		int count=dao.count("select count(id) from Employee where name like '%"+name+"%' order by id desc").intValue();
		return new PageList<Employee>(list, page, size, count);
	}
}
