package com.xiaohe.mapper;

import com.xiaohe.bean.Producttransactionreport;

public interface ProducttransactionreportMapper {
    int deleteByPrimaryKey(Integer transactionid);

    int insert(Producttransactionreport record);

    int insertSelective(Producttransactionreport record);

    Producttransactionreport selectByPrimaryKey(Integer transactionid);

    int updateByPrimaryKeySelective(Producttransactionreport record);

    int updateByPrimaryKey(Producttransactionreport record);
}