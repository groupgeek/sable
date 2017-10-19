package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Returnvisit;

public interface ReturnvisitMapper {
    int deleteByPrimaryKey(Integer returnvisitid);

    int insert(Returnvisit record);

    int insertSelective(Returnvisit record);

    Returnvisit selectByPrimaryKey(Integer returnvisitid);

    int updateByPrimaryKeySelective(Returnvisit record);

    int updateByPrimaryKey(Returnvisit record);
    
    /**
     * 查询分店的回访记录
     * @param id
     * @return
     */
    List<Returnvisit> branchReturnVist(Integer id);
}