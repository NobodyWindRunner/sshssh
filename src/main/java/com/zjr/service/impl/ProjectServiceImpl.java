package com.zjr.service.impl;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zjr.dao.BaseDao;
import com.zjr.entity.Project;
import com.zjr.service.ProjectService;
import com.zjr.util.PageList;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private BaseDao<Project> dao;
	
	@Override
	public int add(Project pro) {
		// TODO Auto-generated method stub
		return dao.save(pro);
	}

	@Override
	public boolean del(Project pro) {
		// TODO Auto-generated method stub
		return dao.delete(pro);
	}
	
	@Override
	public boolean del(int id) {
		// TODO Auto-generated method stub
		return dao.delete(Project.class,id);
	}
	
	@Override
	public boolean update(Project pro) {
		// TODO Auto-generated method stub
		return dao.update(pro);
	}

	@Override
	public Project get(int id) {
		// TODO Auto-generated method stub
		return dao.get(Project.class, id);
	}

	@Override
	public PageList<Project> queryHQLByPage( int page,
			int size) {
		List<Project> list=dao.queryHQLByPage("from Project where statusVal<2 order by id desc", false, page, size);
		// 防止获取到当前页面的数据为刚刚那条数据的那一页，而导致没有数据，这里做判断
		if (list.size() == 0 && page > 1) {
			page = page - 1;// 返回上一页数据
			list = dao.queryHQLByPage("from Project where statusVal<2 order by id desc", false,page, size);	
		}
		int count = dao.count("select count(id) from Project").intValue();
		return new PageList<Project>(list, page, size, count);
	}
	

	@Override
	public PageList<Project> queryHisHQLByPage(int page, int size) {
		List<Project> list=dao.queryHQLByPage("from Project where statusVal>1 order by id desc", false, page, size);
		// 防止获取到当前页面的数据为刚刚那条数据的那一页，而导致没有数据，这里做判断
		if (list.size() == 0 && page > 1) {
			page = page - 1;// 返回上一页数据
			list = dao.queryHQLByPage("from Project where statusVal>1 order by id desc", false,page, size);	
		}
		int count = dao.count("select count(id) from Project where statusVal>1").intValue();
		return new PageList<Project>(list, page, size, count);
	}
	
	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return dao.count("select count(id) from Project");
	}
	
	@Override
	public boolean checkName(String proName) {
		// TODO Auto-generated method stub
		Project pro=dao.get("from Project where proName=?", proName);
		return pro!=null;
	}

}
