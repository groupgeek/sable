package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Product;
import com.xiaohe.bean.ProductCustom;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productid);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productid);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

    
    /**
     * 商品查询(包括商品名字模糊查询，也可以分页) 按照购买次数排序
     * @param custom 条件
     * @return
     */
    List<ProductCustom> selectPopularProductByCondition(ProductCustom custom);
    
    
    /**
     * 查询分店的全部商品数量
     * @param id
     * @return
     */
    int branchCountProducts(Integer id);
    
    /**
     * 查询分店的热销商品
     * @return
     */
    List<ProductCustom> branchHotProduct(Integer id);
    
    /**
     * 模糊查询,查询字段：名字，描述
     * @param condition
     * @return
     */
    List<ProductCustom> selectProductByBlurryCondition(String condition);
}