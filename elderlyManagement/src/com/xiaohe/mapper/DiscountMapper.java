package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Discount;
import com.xiaohe.bean.ProductCustom;

public interface DiscountMapper {
    int deleteByPrimaryKey(Integer discountid);

    int insert(Discount record);

    int insertSelective(Discount record);

    Discount selectByPrimaryKey(Integer discountid);

    int updateByPrimaryKeySelective(Discount record);

    int updateByPrimaryKey(Discount record);
    
    /**
     * 查询优惠商品
     * @param total 条数
     * @return 集合
     */
    List<ProductCustom> selectDiscountProducts(Integer total);
}