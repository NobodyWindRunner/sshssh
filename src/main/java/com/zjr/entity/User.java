package com.zjr.entity;

import javax.persistence.*;

import lombok.Data;

/**
 * 用户bean
 */
@Data
@Entity
@Table(name="DB_User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(length=32)
	private Integer id;
	
	@Column(length=32)  
	private String loginName;
	
	@Column(length=32)  
	private String password;
	
	//用户状态,1正常2失效 默认1
	@Column(columnDefinition="int default 1")
	private Integer statusVal=1;	
}
