package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Orders;
import com.xiaohe.bean.OrdersCustom;
@Transactional
public interface OrdersService {
	/**
	 * 根据订单id查询单条订单信息
	 * @param orderid
	 * @return
	 * @throws Exception
	 */
	Orders selectByPrimaryKey(String orderid) throws Exception;
	/**
	 * 根据分店id获取高分店的所有订单信息
	 * @param branchid
	 * @return
	 * @throws Exception
	 */
	List<Orders> selectAllOrdersByBranchId(Integer branchid) throws Exception;
	
	public void deleteByPrimaryKey(String orderid) throws Exception;
	
	public void updateByPrimaryKey(Orders record) throws Exception;
	
	/*public void deleteByBranchId(Integer branchid) throws Exception;*/
	
	Orders selectByPrimaryKey2(String orderid) throws Exception;
	
	
	/**
	 * 提交订单
	 * @param info
	 * @return
	 */
	boolean submitOrder(OrdersCustom info);
	
}
