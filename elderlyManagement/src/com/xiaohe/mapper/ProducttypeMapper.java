package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Producttype;
import com.xiaohe.bean.ProducttypeCustom;

public interface ProducttypeMapper {
    int deleteByPrimaryKey(Integer producttypeid);

    int insert(Producttype record);

    int insertSelective(Producttype record);

    Producttype selectByPrimaryKey(Integer producttypeid);

    int updateByPrimaryKeySelective(Producttype record);

    int updateByPrimaryKey(Producttype record);
    
    /**
     * 查询商品类型
     * @param productType 查询条件
     * @return 集合
     */
    List<ProducttypeCustom> selectProductTypeBycondition(ProducttypeCustom productType);
    
    /**
     * 根据父类名字查询子类商品类型
     * @param producttype 父类
     * @return
     */
    List<ProducttypeCustom> selectProductTypeByFatherId(ProducttypeCustom producttype);
    
    /**
     * 查询小商品类型
     * @param productType 查询条件
     * @return 集合 ProducttypeCustom
     */
    List<ProducttypeCustom> selectSmallProductType(ProducttypeCustom productType);
    
    /**
     * 花查询出所有的父类型
     * @return
     */
    List<ProducttypeCustom> selectAllFatherType();
    
    /**
     * 根据父类id查询子类商品类型
     * @param producttype 父类
     * @return
     */
    List<ProducttypeCustom> selectProductTypeByFather(Integer id);
}