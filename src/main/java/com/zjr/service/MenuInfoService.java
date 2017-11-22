package com.zjr.service;

import java.util.List;

import com.zjr.entity.MenuInfo;

/**
 * @author 林屹
 * 创建时间 : 2015年2月4日上午8:42:27
 * @category 菜单数据接口
 */
public interface MenuInfoService {

	/**
	 * @param menuInfo
	 * @return 添加菜单
	 */
	boolean add(MenuInfo menuInfo);
	
	/**
	 * @return 返回所以菜单
	 */
	List<MenuInfo> query();

	/**
	 * @param id
	 * @return 根据主键删除菜单
	 */
	boolean del(MenuInfo menuInfo);
	/**
	 * @param id
	 * @return 根据主键获取菜单
	 */
	MenuInfo get(int id);
	/**
	 * @param menuInfo
	 * @return 修改菜单数据
	 */
	boolean update(MenuInfo menuInfo);

	
}
