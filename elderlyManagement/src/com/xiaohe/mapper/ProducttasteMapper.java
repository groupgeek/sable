package com.xiaohe.mapper;

import com.xiaohe.bean.Producttaste;

public interface ProducttasteMapper {
    int deleteByPrimaryKey(Integer producttasteid);

    int insert(Producttaste record);

    int insertSelective(Producttaste record);

    Producttaste selectByPrimaryKey(Integer producttasteid);

    int updateByPrimaryKeySelective(Producttaste record);

    int updateByPrimaryKey(Producttaste record);
}