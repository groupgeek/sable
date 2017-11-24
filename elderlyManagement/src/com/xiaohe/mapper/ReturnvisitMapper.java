package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Returnvisit;
import com.xiaohe.bean.ReturnvisitCustom;

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
    
    /**
     * 查询记录信息
     * @param condition
     * @return
     */
    List<ReturnvisitCustom> selectAllRecordByCondition(ReturnvisitCustom condition);
    
    /**
     * 查询记录数量（管理员 同上一起用）
     * @param condition
     * @return
     */
    Integer selectAllRecordSumByCondition(ReturnvisitCustom condition);
    
    /**
     * 查询单条记录 包括用户 admin
     * @param id
     * @return
     */
    ReturnvisitCustom selectRecordById(Integer id);
}