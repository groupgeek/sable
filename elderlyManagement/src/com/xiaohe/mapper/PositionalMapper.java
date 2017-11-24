package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Positional;
import com.xiaohe.bean.PositionalCustom;

public interface PositionalMapper {
    int deleteByPrimaryKey(Integer positionid);

    int insert(Positional record);

    int insertSelective(Positional record);

    Positional selectByPrimaryKey(Integer positionid);

    int updateByPrimaryKeySelective(Positional record);

    int updateByPrimaryKey(Positional record);
    
    List<PositionalCustom> selectAll();
}