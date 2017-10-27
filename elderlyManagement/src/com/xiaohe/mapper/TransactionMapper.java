package com.xiaohe.mapper;

import java.util.List;

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
}