package com.xiaohe.mapper;

import com.xiaohe.bean.Productcolour;

public interface ProductcolourMapper {
    int deleteByPrimaryKey(Integer productcolourid);

    int insert(Productcolour record);

    int insertSelective(Productcolour record);

    Productcolour selectByPrimaryKey(Integer productcolourid);

    int updateByPrimaryKeySelective(Productcolour record);

    int updateByPrimaryKey(Productcolour record);
}