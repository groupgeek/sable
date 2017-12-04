package com.xiaohe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaohe.bean.Employee;
import com.xiaohe.bean.EmployeeCustom;
import com.xiaohe.bean.Orders;
import com.xiaohe.service.OrdersService;
import com.xiaohe.service.ProductManageService;

@Controller
@RequestMapping("/selectorder")
public class OrdersController {
	
	@Autowired
	@Qualifier("ordersService")
	private OrdersService ordersService;
	
	@Autowired
	@Qualifier("productManageService")
	private ProductManageService productManageService;
	

	@RequestMapping(value="selectorderbyorderid",method={RequestMethod.POST,RequestMethod.GET})
	public String selectByPrimaryKey(String orderid,Model model) throws Exception{	
		
		Orders orderOne = new Orders();
	    orderOne = ordersService.selectByPrimaryKey(orderid);
	  	model.addAttribute("orderOne", orderOne);	
		return "/deliverymanlogReg/page/updateorder";
	}
	
	
	@RequestMapping(value="selectorderbybranchid",method={RequestMethod.POST,RequestMethod.GET})  
	public String selectAllOrdersByBranchId(Integer branchid,Model model,HttpServletRequest request) throws Exception{ 
		EmployeeCustom employeeCustom = (EmployeeCustom) request.getSession().getAttribute("admins");
		List<Orders> orderList = ordersService.selectAllOrdersByBranchId(employeeCustom.getBranchId());
		model.addAttribute("orderList",orderList);
		return "/deliverymanlogReg/page/showorders";
	} 
	
	@RequestMapping(value="deleteorderbyid",method={RequestMethod.POST,RequestMethod.GET}) 
	public String deleteByPrimaryKey(String orderid) throws Exception{
		
		ordersService.deleteByPrimaryKey(orderid);
		
		return "/deliverymanlogReg/page/showorders";
	}
	
	@RequestMapping(value="updateorderbyid",method={RequestMethod.POST,RequestMethod.GET})
	public String updateByPrimaryKey(Orders record,HttpServletRequest request) throws Exception {
		
		EmployeeCustom employeeCustom = (EmployeeCustom) request.getSession().getAttribute("admins");
		record.setBranchid(employeeCustom.getBranchId());
		ordersService.updateByPrimaryKey(record);
		return "redirect:/selectorder/selectorderbybranchid.action";   
	}
	
}