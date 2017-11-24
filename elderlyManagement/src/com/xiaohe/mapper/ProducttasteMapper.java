package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Producttaste;
import com.xiaohe.bean.ProducttasteCustom;

public interface ProducttasteMapper {
    int deleteByPrimaryKey(Integer producttasteid);

    int insert(Producttaste record);

    int insertSelective(Producttaste record);

    Producttaste selectByPrimaryKey(Integer producttasteid);

    int updateByPrimaryKeySelective(Producttaste record);

    int updateByPrimaryKey(Producttaste record);
    /**
     * 
     * @return 库存总数
     */
    List<Integer> countStock();
    
    /**
     *  商品口味
     * @param productid
     * @return 商品口味集合
     */
    List<ProducttasteCustom> quertyProducttasteByid(Integer productid);
    
    /**
     * 根据产品id删除口味
     */
    int deleteProducttasteByProductid(Integer productid);
    
    /**
     * 查询口味
     * @param productid
     * @return
     */
    List<ProducttasteCustom> selectasteByProductid(Integer productid);
    
    
    
}