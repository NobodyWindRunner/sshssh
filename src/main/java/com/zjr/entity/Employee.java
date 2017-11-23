package com.zjr.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 员工bean
 */
@Data
@Entity
@Table(name="DB_Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=32)
    private Integer id;

    @Column(length=32)
    private String name;

    @Column
    private String sex;

    @Column
    private String job;

    @ManyToOne// 指定多对一关系
    @JoinColumn(name="DEPT_ID")
    private Department deptId;
}
