package com.zjr.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjr.controller.BaseController;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @category 注入servlet api组件
 */
@Component
public class ServletApiInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod method=(HandlerMethod)handler;
		BaseController base=(BaseController)method.getBean();
		//System.out.println("进入拦截器");
		if(base!=null){
			base.setRequest(request);
			base.setResponse(response);
			base.setSession(request.getSession());
			//System.out.println("注入成功");
		}
		return super.preHandle(request, response, handler);
	}
	
}
