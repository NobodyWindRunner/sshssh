package com.zjr.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 部门bean
 */
@Data
@Entity
@Table(name="DB_Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length=32)
    private Integer id;

    @Column
    private String name;

//    @OneToMany                                          //指定一对多关系
//    @JoinColumn(name="dept_id")                       //指定与本类主键所对应的外表的外键
//    private Set<Employee> emp;


}
