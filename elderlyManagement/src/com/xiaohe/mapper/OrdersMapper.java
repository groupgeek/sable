package com.xiaohe.mapper;

import java.math.BigDecimal;

import com.xiaohe.bean.Orders;

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
}