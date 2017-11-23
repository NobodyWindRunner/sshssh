package com.zjr.entity;

import javax.persistence.*;

import lombok.Data;

/**
 * 项目bean
 */

@Data
@Entity
@Table(name="DB_Project")
public class Project {
	
	//项目编号
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length=32)
	private Integer id;
	
	//项目名称
	@Column(length=32)  
	private String proName;
	
	//项目描述
	@Column(length=32)
	private String detail;
	
	//项目状态,0未启动 1进行中 2已完成 3已删除
	@Column(columnDefinition="int default 1")
	private Integer statusVal=1;
}
