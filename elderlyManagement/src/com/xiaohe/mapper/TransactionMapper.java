package com.xiaohe.mapper;

import com.xiaohe.bean.Transaction;

public interface TransactionMapper {
    int deleteByPrimaryKey(Integer transactionid);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(Integer transactionid);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);
}