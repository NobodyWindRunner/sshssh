package com.zjr.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;

/**
 *  菜单bean
 */
@Data
@Entity
@Table(name = "db_MenuInfo")
public class MenuInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	// 菜单编号
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	// 菜单名称
	@Column(name = "menuName",nullable=false,length=100)
	private String menuName;
	
	
	// 连接地址
	@Column(name = "menuUrl",length=150)
	private String menuUrl;
	
	// 字段排序
	@OrderBy
	@Column(name = "orderNum",nullable=false)
	private Integer orderNum;
	
	// 功能说明
	@Column(name = "menuDesc",length=1000)
	private String menuDesc;
	
	// 页面截图
	@Column(name = "imgUrl",length=100)
	private String imgUrl;
	
	// 父类别
	@JoinColumn(name = "parentId",nullable=false)
	private Integer parentId;
}
