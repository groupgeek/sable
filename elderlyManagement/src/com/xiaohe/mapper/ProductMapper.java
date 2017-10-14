package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Product;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);
    
    /**
     * 查询出热门的商品（购买次数）
     * @param no  多少个商品数量
     * @return
     */
    List<Product> selectPopularProductByRank(Integer no);
}