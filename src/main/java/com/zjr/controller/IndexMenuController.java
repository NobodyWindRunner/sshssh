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
public class IndexMenuController{
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

	@RequestMapping(value = "login")
	public String index(HttpServletRequest req){
		//登录页
		return "login";
	}

	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest req, HttpServletResponse rep,HttpSession session) throws IOException, IOException {
		session = req.getSession(false);
		if(session!=null){
			session.removeAttribute("adminsession");
		}
		return "login";
	}

	@RequestMapping(value = "index")
    public String login(User user,HttpServletRequest req,HttpSession session)throws IOException{
    	if(user.getId()==null&&user.getPassword()==null){
			req.setAttribute("message", "请输入用户名跟密码");
    	}else if(user.getId()==null){
			req.setAttribute("message", "用户名不能为空");
    	}else if(user.getPassword()==null){
			req.setAttribute("message", "密码不能为空");
    		return "login";
    	}else{
    		User logUser =loginService.login(user.getId(), user.getPassword());
    		if(logUser!=null){
				session.setAttribute("adminsession", logUser);
				this.addMenu(req);
				return "index";
			}
			req.setAttribute("message", "用户名或密码错误");
    	}
    	return "login";
    }
}
