package com.zjr.controller;

import com.zjr.entity.Employee;
import com.zjr.service.DepartmentService;
import com.zjr.service.EmployeeService;
import com.zjr.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 员工控制层
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	@Autowired
	private DepartmentService depService;

	 @RequestMapping("new")
	 public String data(HttpServletRequest req){
	 	req.setAttribute("depList", depService.queryAll());
		return "employee/empEdit";
	 }

	 @RequestMapping(value = "add", method = RequestMethod.GET)
	 public String add(Employee emp, String dept, HttpServletRequest req, HttpServletResponse rep) throws IOException{
		 //所有情况都需要预先载入该下拉列表
	 	req.setAttribute("depList", depService.queryAll());
	 	if(emp.getName()!=null&&emp.getName()!=""){
	 		if(depService.getByName(dept)!=null){
				emp.setDeptId(depService.getByName(dept));
				int newId=empService.add(emp);
				emp=empService.get(newId);
				req.setAttribute("obj", emp);
				req.setAttribute("message", "添加编号为 "+emp.getId()+" 员工成功！");
			}
			req.setAttribute("message","该部门不存在，请添加该部门！");
			return "employee/empEdit";
	    }
		 req.setAttribute("message", "员工姓名不能为空！");
	    return "employee/empEdit";
	 }
	 
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(Employee emp,Integer dept,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException{
		emp.setDeptId(depService.get(dept));
		req.setAttribute("obj", emp);
	 	if(emp.getName()!=null&&emp.getName()==""){
			req.setAttribute("message", "当前员工为 编号"+emp.getId()+" 员工！员工姓名不能为空！");
			return "employee/empEdit";
		}
		empService.update(emp);
		return list(page, req);
	}
	    
	@RequestMapping("list")
	public String list(Integer page, HttpServletRequest req){
		PageList<Employee> data=empService.queryHQLByPage(page==null?1:page,8);
		req.setAttribute("data", data);
		req.setAttribute("page", page);
		return "employee/empList";
	}
	    
	@RequestMapping("del")
	public String del(Integer id,Integer page, HttpServletRequest req){
		empService.del(id);
		return list(page, req);
	}
	    
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public String get(int id,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException{
		Employee emp = empService.get(id);
		req.setAttribute("depList", depService.queryAll());
		if(emp.getId()==null){
			return list(page, req);
		}else{
			req.setAttribute("obj", emp);
			req.setAttribute("page", page);
			req.setAttribute("message", "当前员工为 编号"+emp.getId()+" 员工！");
			return "employee/empEdit";
		}
	}

	@RequestMapping(value = "like", method = RequestMethod.GET)
	public String like(String name,Integer page,HttpServletRequest req,HttpServletResponse rep){
		PageList<Employee> data=empService.queryByName(name, page==null?1:page,8);
		req.setAttribute("data", data);
		req.setAttribute("page", page);
		return "employee/empList";
	}
}
