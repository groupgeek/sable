package com.xiaohe.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.xiaohe.bean.Producttransactionreport;
import com.xiaohe.bean.ProducttransactionreportCustom;

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
    /**
     * 根据商品id,用户id查询该商品所有的交易记录,对sort赋值可以让其排序,也可以规定显示的数量进行分页,还可以查询某一个时间段的数据
     * @param condition 条件
     * @return
     */
    List<ProducttransactionreportCustom> selectByCondition(ProducttransactionreportCustom condition);
    
    /**
     * 根据用户id或者产品id或者某一时阿段或者一起，查询该用户或该产品的交易数据的总和，购买次数，总钱，总支出
     * @param condition
     * @return
     */
    ProducttransactionreportCustom selectSumByCondition(ProducttransactionreportCustom condition);
    
}