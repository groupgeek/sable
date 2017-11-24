package com.xiaohe.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xiaohe.bean.Authority;
import com.xiaohe.bean.AuthorityCustom;
import com.xiaohe.bean.Employee;
import com.xiaohe.bean.Positional;
import com.xiaohe.bean.PositionalCustom;
import com.xiaohe.service.AuthorityService;
import com.xiaohe.service.PositionalSerice;

public class AdminAuthorityInterceptor implements HandlerInterceptor{
	@Autowired
	private PositionalSerice positionalSerice;
	
	@Autowired
	private AuthorityService authorityService;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		//String path= request.getRequestURI();
		Employee employee = new Employee();
		employee = (Employee) request.getSession().getAttribute("admins");
		if(employee != null){
			
			//查询职位
			Positional posi = new Positional();
			posi = positionalSerice.queryByPositionalId(employee.getPositionid());
			
			//查询管理员权限
			Authority auth = new Authority();
			auth = authorityService.queryByAuthorityId(employee.getAuthorityid());
			
			
			//权限判断
			if(Integer.parseInt(auth.getAuthoritylevel()) < posi.getMinauthority()){
				String XRequested =request.getHeader("X-Requested-With");
			      if("XMLHttpRequest".equals(XRequested)){
			        response.getWriter().write("IsAjaxAuthAdmin");
			      }else{
			    	request.getRequestDispatcher("/jsp/AdminLogin/login.jsp").forward(request, response);
			      }
				return false;
			}else{
				
			}
		}else{
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
