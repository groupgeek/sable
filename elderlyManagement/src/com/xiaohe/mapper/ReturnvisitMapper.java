package com.xiaohe.mapper;

import com.xiaohe.bean.Returnvisit;

public interface ReturnvisitMapper {
    int deleteByPrimaryKey(Integer returnvisitid);

    int insert(Returnvisit record);

    int insertSelective(Returnvisit record);

    Returnvisit selectByPrimaryKey(Integer returnvisitid);

    int updateByPrimaryKeySelective(Returnvisit record);

    int updateByPrimaryKey(Returnvisit record);
}