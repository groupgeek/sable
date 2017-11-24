package com.xiaohe.mapper;

import com.xiaohe.bean.Integralreport;

public interface IntegralreportMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Integralreport record);

    int insertSelective(Integralreport record);

    Integralreport selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Integralreport record);

    int updateByPrimaryKey(Integralreport record);
}