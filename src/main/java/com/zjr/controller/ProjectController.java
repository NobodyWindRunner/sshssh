package com.zjr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjr.entity.Project;
import com.zjr.service.ProjectService;
import com.zjr.util.PageList;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectService proService;
	
	 @RequestMapping(value = "add", method = RequestMethod.GET)
	    public String add(Project pro,HttpServletRequest req,HttpServletResponse rep) throws IOException{
	    	if(pro.getProName()!=null&&pro.getProName()!=""){
	    		int newId=proService.add(pro);
	    		pro=proService.get(newId);
	    		req.setAttribute("message", "添加编号为 "+pro.getId()+" 项目成功！");		
	    	}
	    	return "project/proEdit";
	    }
	 
	    @RequestMapping(value = "update", method = RequestMethod.GET)
	    public String update(Project pro,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException{
	    	if(pro.getProName()!=null&&pro.getProName()==""){
	    		req.setAttribute("message", "项目名称不能为空！");		
	    		return "project/proEdit";
	    	}
	    	proService.update(pro);
	    	req.setAttribute("obj", pro);
	    	return list(page, req);
	    }
	    
	    @RequestMapping("list")
		public String list(Integer page, HttpServletRequest req){
			PageList<Project> data=proService.queryHQLByPage(page==null?1:page,8);
			req.setAttribute("data", data);
			req.setAttribute("page", page);
			return "project/proList";
		}
	    
	    @RequestMapping("hislist")
		public String hislist(Integer page, HttpServletRequest req){
			PageList<Project> data=proService.queryHisHQLByPage(page==null?1:page,8);
			req.setAttribute("data", data);
			req.setAttribute("page", page);
			return "project/proHisList";
		}
	     
	    @RequestMapping("del")
		public String del(Integer id,Integer page, HttpServletRequest req){
			proService.del(id);	
			return list(page, req);
		}
	    
	    @RequestMapping(value = "get", method = RequestMethod.GET)
	    public String get(int id,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException{
	    	Project pro = proService.get(id);
	    	if(pro.getId()==null){
	    		return list(page, req);
	    	}else{
	    		req.setAttribute("obj", pro);
	    		req.setAttribute("page", page);
	    		req.setAttribute("message", "当前项目 编号"+pro.getId());		
	    		return "project/proEdit";
	    	}     	
	    }
	    
		@ResponseBody
		@RequestMapping(value = "check",method = RequestMethod.GET)
		public String check(String proName, HttpServletRequest req){
			String str="success";
			if(proService.checkName(proName)){
				str="fail";
			}
			return str;
		}

}
