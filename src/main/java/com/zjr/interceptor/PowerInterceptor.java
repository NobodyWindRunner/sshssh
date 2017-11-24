package com.zjr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.zjr.entity.User;


/**
 * @category 权限验证拦截器，控制权限
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
