package com.zjr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zjr.entity.User;


/**
 * 登录拦截器，拦截未登录就访问的请求
 */
public class PowerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception {
		HttpSession session= request.getSession();
		User user=(User)session.getAttribute("adminsession");
		if(user==null){
			request.setAttribute("message",  "请先登陆或登陆过期");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			return false;
		}
		return true;
	}

}
