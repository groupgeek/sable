package com.xiaohe.mapper;

import com.xiaohe.bean.Area;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer areaid);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer areaid);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);
}