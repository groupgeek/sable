package com.xiaohe.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.xiaohe.bean.Orders;
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
	
	public int deleteByPrimaryKey(String orderid) throws Exception;
}
