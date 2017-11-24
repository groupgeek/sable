
package com.xiaohe.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.xiaohe.bean.Orders;
import com.xiaohe.bean.OrdersCustom;

public interface OrdersMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(Orders record);

    int insertSelective(Orders record);

    Orders selectByPrimaryKey(String orderid);

    int updateByPrimaryKeySelective(Orders record);

    int updateByPrimaryKey(Orders record);
    
    
    /**
     * 查询分店订单的总收入
     * @return
     */
    BigDecimal queryBranchOderIncome(Integer id);
    
    
   /* BigDecimal branchIncome();*/
    
    int branchCountOrders(Integer id);

    /**
     * 查询订单总数
     * @return
     */
    int selectCountOrder();


	List<Orders> selectAllOrdersByBranchId(Integer branchid);

	Orders selectByPrimaryKey2(String orderid);
	
	/**
	 * 根据id查询订单详细信息
	 * @param id
	 * @return
	 */
	OrdersCustom selectOrdersByOrdersId(String id);
	
	/**
	 * 根据用户跟新订单信息
	 * @param record
	 * @return
	 */
	int updateByUseridSelective(OrdersCustom record);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	int deleteOrdersById(String id);
	
	/**
	 * 根据logo查询相应的订单
	 * @param condition
	 * @return
	 */
	List<OrdersCustom> selectOrdersByLogo(OrdersCustom condition);
	
	/**
	 * 计算某一状态或者其他条件 总数
	 * @param condition
	 * @return
	 */
	Integer selectCountByLogo(OrdersCustom condition);
	
	/**
	 * 查询分店阶段的收入情况(分店商品总报表)
	 * @param ordersCustom
	 * @return
	 */
	OrdersCustom orderReport(OrdersCustom ordersCustom);
	/**
	 * 按月份查询分店一年的订单收入
	 * @param id
	 * @return
	 */
	List<OrdersCustom> CeoBranchOrderIncome(Integer id);
}