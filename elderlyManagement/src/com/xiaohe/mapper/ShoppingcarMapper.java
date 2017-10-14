package com.xiaohe.mapper;

import com.xiaohe.bean.Shoppingcar;

public interface ShoppingcarMapper {
    int deleteByPrimaryKey(Integer shoppingcarid);

    int insert(Shoppingcar record);

    int insertSelective(Shoppingcar record);

    Shoppingcar selectByPrimaryKey(Integer shoppingcarid);

    int updateByPrimaryKeySelective(Shoppingcar record);

    int updateByPrimaryKey(Shoppingcar record);
}