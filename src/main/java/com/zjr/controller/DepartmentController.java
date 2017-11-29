package com.zjr.controller;

import com.zjr.entity.Department;
import com.zjr.entity.Employee;
import com.zjr.service.DepartmentService;
import com.zjr.service.EmployeeService;
import com.zjr.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 用户控制层
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService depService;
	@Autowired
	private EmployeeService empService;

    @RequestMapping("new")
    public String data(HttpServletRequest req){
        return "department/depEdit";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Department dep,HttpServletRequest req,HttpServletResponse rep) throws IOException{
        if(dep.getName()!=null&&dep.getName()!=""){
            int newId=depService.add(dep);
            dep=depService.get(newId);
            req.setAttribute("obj", dep);
            req.setAttribute("message", "添加编号为 "+dep.getId()+" 部门成功！");
            return "department/depEdit";
        }
        req.setAttribute("message", "部门名不能为空！");
        return "department/depEdit";
    }

    @RequestMapping(value = "update", method = RequestMethod.GET)
    public String update(Department dep,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException{
        req.setAttribute("obj", dep);
        if(dep.getName()!=null&&dep.getName()==""){
            req.setAttribute("message", "当前部门为 编号"+dep.getId()+" 部门！部门名不能为空！");
            return "department/depEdit";
        }
        depService.update(dep);
        return list(page, req);
    }

    @RequestMapping("list")
    public String list(Integer page, HttpServletRequest req){
        PageList<Department> data=depService.queryHQLByPage(page==null?1:page,8);
        req.setAttribute("data", data);
        req.setAttribute("page", page);
        return "department/depList";
    }
	    
    @RequestMapping("del")
    public String del(Integer id,Integer page, HttpServletRequest req){
        depService.del(id);
        return list(page, req);
    }
	    
    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String get(int id,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException{
        Department dep = depService.get(id);
        if(dep.getId()==null){
            return list(page, req);
        }else{
            req.setAttribute("obj", dep);
            req.setAttribute("page", page);
            req.setAttribute("message", "当前部门为 编号"+dep.getId()+" 部门！");
            return "department/depEdit";
        }
    }

    @ResponseBody
    @RequestMapping(value = "check",method = RequestMethod.GET)
    public String check(String name, HttpServletRequest req){
        String str="success";
        if(depService.checkName(name)){
            str="fail";
        }
        return str;
    }

    @RequestMapping("listForEmp")
    public String listForEmp(int id,Integer page, HttpServletRequest req){
        PageList<Employee> data=empService.queryHQLForDepByPage(id,page==null?1:page,8);
        req.setAttribute("data", data);
        req.setAttribute("page", page);
        return "employee/empList";
    }
}
