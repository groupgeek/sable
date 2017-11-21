package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.ActivityCustom;
import com.xiaohe.bean.Transaction;
import com.xiaohe.bean.TransactionCustom;

public interface TransactionMapper {
    int deleteByPrimaryKey(Integer transactionid);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(Integer transactionid);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
    
    List<TransactionCustom> branchAlltran(Integer id);
    
    /**
     * 查询记录信息
     * @param condition
     * @return
     */
    List<TransactionCustom> selectAllRecordByCondition(TransactionCustom condition);
    
    /**
     * 查询记录数量（管理员 同上一起用）
     * @param condition
     * @return
     */
    Integer selectAllRecordSumByCondition(TransactionCustom condition);
    
    /**
     * 查询单条记录 包括用户 admin
     * @param id
     * @return
     */
    TransactionCustom selectRecordById(Integer id);
    
    /**
     * 跟新用户交易表 根据userid
     * @param record
     * @return
     */
    Integer updateRecordByUserId(TransactionCustom record);
    
    /**
     * 根据用户id查询心记录
     * @param userid
     * @return
     */
    TransactionCustom selectTransactionByUserId(Integer userid);
}