package com.xiaohe.mapper;

import com.xiaohe.bean.Integralorder;

public interface IntegralorderMapper {
    int deleteByPrimaryKey(String integralorderid);

    int insert(Integralorder record);

    int insertSelective(Integralorder record);

    Integralorder selectByPrimaryKey(String integralorderid);

    int updateByPrimaryKeySelective(Integralorder record);

    int updateByPrimaryKey(Integralorder record);
    
    Integer selectCountOrder();
}