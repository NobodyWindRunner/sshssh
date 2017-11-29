package com.zjr.service.impl;

import com.zjr.dao.BaseDao;
import com.zjr.entity.Department;
import com.zjr.service.DepartmentService;
import com.zjr.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private BaseDao<Department> dao;
	
	@Override
	public int add(Department department) {
		// TODO Auto-generated method stub
		return dao.save(department);
	}

	@Override
	public boolean del(Department department) {
		// TODO Auto-generated method stub
		return dao.delete(department);
	}
	
	@Override
	public boolean del(int id) {
		// TODO Auto-generated method stub
		return dao.delete(Department.class,id);
	}
	
	@Override
	public boolean update(Department department) {
		// TODO Auto-generated method stub
		return dao.update(department);
	}

	@Override
	public Department get(int id) {
		// TODO Auto-generated method stub
		return dao.get(Department.class, id);
	}

	@Override
	public Department getByName(String name) {
		// TODO Auto-generated method stub
		return dao.get("from Department where name=?", name);
	}

	@Override
	public PageList<Department> queryHQLByPage( int page,
			int size) {
		List<Department> list=dao.queryHQLByPage("from Department order by id desc", false, page, size);
		// 防止获取到当前页面的数据为刚刚那条数据的那一页，而导致没有数据，这里做判断
		if (list.size() == 0 && page > 1) {
			page = page - 1;// 返回上一页数据
			list = dao.queryHQLByPage("from Department order by id desc", false,page, size);
		}
		int count = dao.count("select count(id) from Department").intValue();
		return new PageList<Department>(list, page, size, count);
	}
	
	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return dao.count("select count(id) from Department");
	}

	@Override
	public List<Department> queryAll() {
		// TODO Auto-generated method stub
		List<Department> list=dao.queryByHQL("from Department order by id desc", false,null);
		return list;
	}

	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		Department department=dao.get("from Department where name=?", name);
		return department!=null;
	}

}
