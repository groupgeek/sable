package com.xiaohe.mapper;

import com.xiaohe.bean.Producttype;

public interface ProducttypeMapper {
    int deleteByPrimaryKey(Integer producttypeid);

    int insert(Producttype record);

    int insertSelective(Producttype record);

    Producttype selectByPrimaryKey(Integer producttypeid);

    int updateByPrimaryKeySelective(Producttype record);

    int updateByPrimaryKey(Producttype record);
}