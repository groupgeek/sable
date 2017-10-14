package com.xiaohe.mapper;

import com.xiaohe.bean.Level;

public interface LevelMapper {
    int deleteByPrimaryKey(Integer levelid);

    int insert(Level record);

    int insertSelective(Level record);

    Level selectByPrimaryKey(Integer levelid);

    int updateByPrimaryKeySelective(Level record);

    int updateByPrimaryKey(Level record);
}