package com.xiaohe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaohe.bean.Employee;
import com.xiaohe.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;
	
	@RequestMapping(value="login")
	public String selectEmployee(Employee employee,HttpServletRequest request, Model model) throws Exception{
 
		Employee employeea = new Employee();
		employeea = employeeService.selectByPrimaryKey(employee.getEmployeeid());
		
		if(employeea == null){
			return "/deliverymanlogReg/loginfailure";//密码为空返回登录失败页面，在跳转到登录页面
		}else if(employeea.getPassword().equals(employee.getPassword())){
			model.addAttribute("employeea", employeea);
			request.getSession().setAttribute("employeea", employeea);
			return "/deliverymanlogReg/loginsuccess";//返回登录成功的界面并进入订单管理界面
		}else {
			return "/deliverymanlogReg/loginfailure";
		}		
	}
}
