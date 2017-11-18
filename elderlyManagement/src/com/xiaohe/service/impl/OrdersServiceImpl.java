package com.xiaohe.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.bean.Orders;
import com.xiaohe.bean.OrdersCustom;
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

	public void deleteByPrimaryKey(String orderid) throws Exception {
		
		 ordersMapper.deleteByPrimaryKey(orderid);
	}

	public void updateByPrimaryKey(Orders record) {
		
		ordersMapper.updateByPrimaryKey(record);
	}

	/*public int deleteByBranchId(Integer branchid) throws Exception {
		
		return ordersMapper.deleteByBranchId(branchid);
	}*/

	public Orders selectByPrimaryKey2(String orderid) throws Exception {
		
		return ordersMapper.selectByPrimaryKey2(orderid);
	}

	public boolean submitOrder(OrdersCustom info) {
		
		if(info == null) return false;
		if(info.getPaymentMethod() == null) return false;
		
		//数据
		OrdersCustom ordersData = new OrdersCustom();//单条订单
		List<OrdersCustom> all = new ArrayList<OrdersCustom>();//订单集合
		//总价
		BigDecimal total = new BigDecimal(0);
		
		
		//更新数据库
		info.setOrderstatus("已付款");
		info.setProductstatus("未发货");
		for(String oid : info.getOrdersid()){
			if("".equals(oid) || oid == null) continue;
			info.setOrderid(oid);
			if(ordersMapper.updateByPrimaryKeySelective(info) <= 0) return false;
		}
		
				
				
		//查询数据库得到订单信息
		for(String oid : info.getOrdersid()){
			if("".equals(oid) || oid == null) continue;
			ordersData = ordersMapper.selectOrdersByOrdersId(oid);
			if(ordersData == null) return false;
			total = total.add(ordersData.getTotalprice());
			all.add(ordersData);
		}
		System.out.println("一共："+total);		
		
		//接口处理
		
		
		
		
		
		
		
		return true;
	}
	
}