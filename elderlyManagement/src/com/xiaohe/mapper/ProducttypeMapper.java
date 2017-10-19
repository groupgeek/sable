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
    

    
}