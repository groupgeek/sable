package com.xiaohe.mapper;

import com.xiaohe.bean.Positional;

public interface PositionalMapper {
    int deleteByPrimaryKey(Integer positionid);

    int insert(Positional record);

    int insertSelective(Positional record);

    Positional selectByPrimaryKey(Integer positionid);

    int updateByPrimaryKeySelective(Positional record);

    int updateByPrimaryKey(Positional record);
}