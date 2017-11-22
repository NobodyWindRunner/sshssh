package com.zjr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zjr.dao.BaseDao;
import com.zjr.entity.MenuInfo;
import com.zjr.service.MenuInfoService;

/**
 * @author 林屹
 * 创建时间 : 2015年2月4日上午8:54:29
 * @category 菜单服务接口的实现
 */
@Service
public class MenuInfoServiceImpl implements MenuInfoService {

	

	@Resource
	private BaseDao<MenuInfo> dao;
	@Override
	public List<MenuInfo> query() {
		// TODO Auto-generated method stub
		return dao.queryByHQL("from MenuInfo", false);
	}

	@Override
	public boolean add(MenuInfo menuInfo) {
		// TODO Auto-generated method stub
		return ((int)dao.save(menuInfo))>0;
	}

	@Override
	public boolean del(MenuInfo menuInfo) {
		// TODO Auto-generated method stub
		return dao.delete(menuInfo);
	}

	@Override
	public MenuInfo get(int id) {
		// TODO Auto-generated method stub
		return dao.get(MenuInfo.class, id);
	}

	@Override
	public boolean update(MenuInfo menuInfo) {
		// TODO Auto-generated method stub
		return dao.update(menuInfo);
	}

}
