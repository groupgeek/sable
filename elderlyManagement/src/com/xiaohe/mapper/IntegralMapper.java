package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Integral;
import com.xiaohe.bean.IntegralCustom;

public interface IntegralMapper {
    int deleteByPrimaryKey(Integer integralid);

    int insert(Integral record);

    int insertSelective(Integral record);

    Integral selectByPrimaryKey(Integer integralid);

    int updateByPrimaryKeySelective(Integral record);

    int updateByPrimaryKey(Integral record);
    
    /**
     * 查询全部积分情况
     * @param userid
     * @return
     */
    List<IntegralCustom> selectIntegralByCondition(IntegralCustom condition);
    
    /**
     * 查询最新记录
     * @param condition
     * @return
     */
    IntegralCustom selectUpToDateRecord(IntegralCustom condition);
    
    
}