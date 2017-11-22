package com.zjr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjr.entity.User;
import com.zjr.service.UserService;
import com.zjr.util.PageList;

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {
	@Autowired
	private UserService userService;
	
	 @RequestMapping(value = "add", method = RequestMethod.GET)
	    public String add(User user,HttpServletRequest req,HttpServletResponse rep) throws IOException{
	    	if((user.getLoginName()!=null&&user.getLoginName()!="")&&(user.getPassword()!=null&&user.getPassword()!="")){
	    		int newId=userService.add(user);
	    		user=userService.get(newId);
	    		req.setAttribute("obj", user);
	    		req.setAttribute("message", "添加编号为 "+user.getId()+" 用户成功！");		
	    	}
	    	return "userinfo/userEdit";
	    }
	 
	    @RequestMapping(value = "update", method = RequestMethod.GET)
	    public String update(User user,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException{
	    	if((user.getLoginName()!=null&&user.getLoginName()=="")||(user.getPassword()!=null&&user.getPassword()=="")){
	    		req.setAttribute("message", "用户名或密码不能为空！");		
	    		return "userinfo/userEdit";
	    	}
	    	userService.update(user);
	    	req.setAttribute("obj", user);
	    	return list(page, req);
	    }
	    
	    @RequestMapping("list")
		public String list(Integer page, HttpServletRequest req){
			PageList<User> data=userService.queryHQLByPage(page==null?1:page,8);
			req.setAttribute("data", data);
			req.setAttribute("page", page);
			return "userinfo/userList";
		}
	    
	    @RequestMapping("del")
		public String del(Integer id,Integer page, HttpServletRequest req){
			userService.del(id);	
			return list(page, req);
		}
	    
	    @RequestMapping(value = "get", method = RequestMethod.GET)
	    public String get(int id,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException{
	    	User user = userService.get(id);
	    	if(user.getId()==null){
	    		return list(page, req);
	    	}else{
	    		req.setAttribute("obj", user);
	    		req.setAttribute("page", page);
	    		req.setAttribute("message", "当前用户为 编号"+user.getId()+" 用户！");		
	    		return "userinfo/userEdit";
	    	}     	
	    }
}
