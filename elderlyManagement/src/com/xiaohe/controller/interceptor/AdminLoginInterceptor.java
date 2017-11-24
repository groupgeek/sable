package com.xiaohe.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xiaohe.bean.Employee;

public class AdminLoginInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//String path= request.getRequestURI();
		Employee employee = new Employee();
		employee = (Employee) request.getSession().getAttribute("admins");
		if(employee == null){
			String XRequested =request.getHeader("X-Requested-With");
		      if("XMLHttpRequest".equals(XRequested)){
		        response.getWriter().write("IsAjaxAdmin");
		      }else{
		    	request.getRequestDispatcher("/jsp/AdminLogin/login.jsp").forward(request, response);
		      }
			return false;
		}
		//response.sendRedirect("/jsp/loReg/login.jsp");
		return true;
	}
	
	//进入Handler方法之后，返回modelAndView之前执行
	public void postHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
	}

	//执行Handler完成执行此方法
		public void afterCompletion(HttpServletRequest request,
				HttpServletResponse response, Object handler, Exception ex)
				throws Exception {
	}
}
