package com.xiaohe.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.xiaohe.bean.CeoProducttransactionreport;
import com.xiaohe.bean.Producttransactionreport;
import com.xiaohe.bean.ProducttransactionreportCustom;

public interface ProducttransactionreportMapper {
    int deleteByPrimaryKey(Integer transactionid);

    int insert(Producttransactionreport record);

    int insertSelective(Producttransactionreport record);

    Producttransactionreport selectByPrimaryKey(Integer transactionid);

    int updateByPrimaryKeySelective(Producttransactionreport record);

    int updateByPrimaryKey(Producttransactionreport record);
    
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
    
    /**
     * 根据商品id,用户id查询该商品所有的交易记录,对sort赋值可以让其排序,也可以规定显示的数量进行分页,还可以查询某一个时间段的数据(分店的，根据管理员id)
     * @param producttransactionreportCustom
     * @return
     */
    List<ProducttransactionreportCustom> selectBranchByCondition(ProducttransactionreportCustom producttransactionreportCustom);

    /**
     * 查询商城的总盈利
     * @param producttransactionreport
     * @return
     */
    BigDecimal selectSumproductAllMoney();

    /**
     * 通过时间查询商城的盈利额
     * @param producttransactionreport
     * @return
     */
    List<BigDecimal> selectSumproductMoney();
    /**
     * 按月份查询一年内的商城盈利
     * @return
     */
    List<CeoProducttransactionreport> CeoProductByTime();
    
    /**
     * 测试用
     * @param id
     * @return
     */
    List<CeoProducttransactionreport> selectProductTest(Integer id);
    
    /**
     * 查询分店的商品销售情况（分店）
     * @param producttransactionreportCustom
     * @return
     */
    List<ProducttransactionreportCustom> BranchProductTransation(ProducttransactionreportCustom producttransactionreportCustom);
    
    /**
     * 根据传入的数据，查询商品一天的销售情况(分店)
     * @param producttransactionreportCustom
     * @return
     */
    ProducttransactionreportCustom oneDayTransation(ProducttransactionreportCustom producttransactionreportCustom);
    
    /**
     * 传入一个时间，处理成 2017-1-1 0:0:0格式
     * @param date
     * @return
     */
    ProducttransactionreportCustom calTime(ProducttransactionreportCustom date);
    
    /**
     * 查询某一时间段的记录
     * @param condition
     * @return
     */
    List<ProducttransactionreportCustom> selectPtByTimeInterval(ProducttransactionreportCustom condition);

    /**
     * 查询分店商品的销售情况（可以传商品id，也可以不传）
     * @param producttransactionreportCustom
     * @return
     */
    ProducttransactionreportCustom BranchOneProductTransation(ProducttransactionreportCustom producttransactionreportCustom);
    
    /**
     * 分店管理员主页用的销售情况
     * @param producttransactionreportCustom
     * @return
     */
    ProducttransactionreportCustom oneDayAllSail(ProducttransactionreportCustom producttransactionreportCustom);
    
    
    /**
     * 分店管理员主页用的销售情况
     * @param producttransactionreportCustom
     * @return
     */
    ProducttransactionreportCustom onedayAllAct(ProducttransactionreportCustom producttransactionreportCustom);
    /**
     * 按月份查询一年内的商城盈利
     * @return
     */
    List<CeoProducttransactionreport> ceoProductByTime();
    /**
     * 按天查询一月内单个商品的销售情况
     * @param id
     * @return
     */
    List<CeoProducttransactionreport> ceoProductByIdinmonth(CeoProducttransactionreport ceoProducttransactionreport);
    /**
     * 按月查询一年内单个商品的销售情况
     * @param ceoProducttransactionreport
     * @return
     */
    List<CeoProducttransactionreport> ceoProductByIdinyear(CeoProducttransactionreport ceoProducttransactionreport);
    /**
     * 按年份查询单个商品的销售情况
     * @param ceoProducttransactionreport
     * @return
     */
    List<CeoProducttransactionreport> ceoProductByIdAllyear(CeoProducttransactionreport ceoProducttransactionreport);
    /**
     * 按分店查询商品的报表
     * @param id
     * @return
     */
    List<CeoProducttransactionreport> ceoproductChartOfBranch(Integer id);
    /**
     * 查询所有商品的报表
     * @return
     */
    List<CeoProducttransactionreport> ceoproductAllchart(CeoProducttransactionreport condition);
    /**
     * 查询报表的数目
     * @param condition
     * @return
     */
    Integer ceoproductchartByCondition(CeoProducttransactionreport condition);
    /**
     * 查询所有商品的报表（做图用）
     * @return
     */
    List<CeoProducttransactionreport> ceofindproductchart();
    /**
     * 查询一年内的商品报表（做饼图用）
     * @return
     */
    CeoProducttransactionreport ceofindproductchartByYear();
    /**
     * 查询全部的商品报表（做饼图用）
     * @return
     */
    CeoProducttransactionreport ceofindproductchartAll();
    /**
     * 查询分店所有商品的报表（做图用）
     * @param id
     * @return
     */
    List<CeoProducttransactionreport> ceodfindproductchartOfbranch(Integer id);
}