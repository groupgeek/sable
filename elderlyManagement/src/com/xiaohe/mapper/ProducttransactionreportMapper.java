package com.xiaohe.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.xiaohe.bean.Producttransactionreport;

public interface ProducttransactionreportMapper {
    int deleteByPrimaryKey(Integer transactionid);

    int insert(Producttransactionreport record);

    int insertSelective(Producttransactionreport record);

    Producttransactionreport selectByPrimaryKey(Integer transactionid);

    int updateByPrimaryKeySelective(Producttransactionreport record);

    int updateByPrimaryKey(Producttransactionreport record);
    
    BigDecimal selectSumproductAllMoney(Producttransactionreport producttransactionreport);
    
    /**
     * 通过时间查询商城的盈利额
     * @param producttransactionreport
     * @return
     */
    List<BigDecimal> selectSumproductMoney(Producttransactionreport producttransactionreport);
}