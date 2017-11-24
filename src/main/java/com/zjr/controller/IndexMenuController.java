package com.zjr.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjr.entity.MenuInfo;
import com.zjr.entity.User;
import com.zjr.service.LoginService;
import com.zjr.service.MenuInfoService;


/**
 * 菜单控制层
 */
@Controller
public class IndexMenuController extends BaseController{
	@Resource
    private MenuInfoService service;
	@Resource
	private LoginService loginService;
	
	@RequestMapping(value="menu",method = RequestMethod.POST)
	public String addMenu(HttpServletRequest req){
		//查询所有菜单
		List<MenuInfo> list=service.query();
		//设置属性将遍历到的集合传到首页
		req.setAttribute("menus", list);
		return "index";
	}

	@RequestMapping(value = "/valid/login")
	public String index(HttpServletRequest req){
		//登录页
		return "login";
	}
	@RequestMapping(value = "index")
    public String login(Integer id,String password,HttpServletRequest rep,HttpServletResponse req,HttpSession session)throws IOException{
    	if(String.valueOf(id)==null&&password==null){
    		rep.setAttribute("message", "请输入用户名跟密码");
    	}else if(String.valueOf(id)==""){
    		rep.setAttribute("message", "用户名不能为空");
    	}else if(password==""){
    		rep.setAttribute("message", "密码不能为空");
    		return "login";
    	}else{
    		User user=loginService.login(id, password);
        	if(user!=null){
        		rep.setAttribute("user", user);
				session.setAttribute("adminsession", user);
        		this.addMenu(rep);
        		return "index";
        	}
    	}	
    	rep.setAttribute("message", "登陆失败");
    	return "login";
    }
}
