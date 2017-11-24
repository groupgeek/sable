package com.xiaohe.mapper;

import com.xiaohe.bean.Productcoloursize;

public interface ProductcoloursizeMapper {
    int deleteByPrimaryKey(Integer sizeid);

    int insert(Productcoloursize record);

    int insertSelective(Productcoloursize record);

    Productcoloursize selectByPrimaryKey(Integer sizeid);

    int updateByPrimaryKeySelective(Productcoloursize record);

    int updateByPrimaryKey(Productcoloursize record);
}