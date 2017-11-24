package com.xiaohe.mapper;

import com.xiaohe.bean.HealthfoodKey;

public interface HealthfoodMapper {
    int deleteByPrimaryKey(HealthfoodKey key);

    int insert(HealthfoodKey record);

    int insertSelective(HealthfoodKey record);
}