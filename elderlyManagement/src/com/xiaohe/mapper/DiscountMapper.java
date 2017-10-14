package com.xiaohe.mapper;

import com.xiaohe.bean.Discount;

public interface DiscountMapper {
    int deleteByPrimaryKey(Integer discountid);

    int insert(Discount record);

    int insertSelective(Discount record);

    Discount selectByPrimaryKey(Integer discountid);

    int updateByPrimaryKeySelective(Discount record);

    int updateByPrimaryKey(Discount record);
}