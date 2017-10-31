package com.xiaohe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaohe.bean.Employee;
import com.xiaohe.bean.Orders;
import com.xiaohe.service.OrdersService;

@Controller
@RequestMapping("/selectorder")
public class OrdersController {
	@Autowired
	@Qualifier("ordersService")
	private OrdersService ordersService;
	
	@RequestMapping(value="selectorderbyorderid")
	public String selectByPrimaryKey(String orderid) throws Exception{
		
		Orders orderOne = new Orders();
	/*	orderOne = ordersService.selectByPrimaryKey("1234");//传入订单id获取订单信息
		System.out.println(orderOne);*/
		return "/deliverymanlogReg/loginfailure";
	}
	
	
	@RequestMapping(value="selectorderbybranchid")  
	public String selectAllOrdersByBranchId(Integer branchid) throws Exception{ 
		
		List<Orders> orderList = ordersService.selectAllOrdersByBranchId(1);//传入分店id获取其所有订单信息
		
		return "/deliverymanlogReg/loginfailure";
	} 
	
	@RequestMapping(value="deleteorderbyid") 
	public String deleteByPrimaryKey(String orderid) throws Exception{
		Orders order = new Orders();
		order = ordersService.selectByPrimaryKey("511");
		System.out.println(order);
		
		ordersService.deleteByPrimaryKey("511");//传入订单id删除订单信息
		
		return "/deliverymanlogReg/loginfailure";
	}
	
}

  




