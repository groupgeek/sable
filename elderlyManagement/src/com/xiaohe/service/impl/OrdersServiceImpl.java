package com.xiaohe.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Orders;
import com.xiaohe.mapper.OrdersMapper;
import com.xiaohe.service.OrdersService;

@Repository("ordersService")
public class OrdersServiceImpl implements OrdersService{
	
	@Autowired
	@Qualifier("ordersMapper")
	private OrdersMapper ordersMapper;
	
	public Orders selectByPrimaryKey(String orderid) throws Exception {
		
		return ordersMapper.selectByPrimaryKey(orderid);
	}

	public List<Orders> selectAllOrdersByBranchId(Integer branchid) throws Exception {
		
		List<Orders>  allOrders = ordersMapper.selectAllOrdersByBranchId(branchid);
		
		return allOrders;
	}

	public int deleteByPrimaryKey(String orderid) throws Exception {
		
		return ordersMapper.deleteByPrimaryKey(orderid);
	}
	
}
