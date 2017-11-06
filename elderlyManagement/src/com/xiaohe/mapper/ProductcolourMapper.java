package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Productcolour;
import com.xiaohe.bean.ProductcolourCustom;

public interface ProductcolourMapper {
    int deleteByPrimaryKey(Integer productcolourid);

    int insert(Productcolour record);

    int insertSelective(Productcolour record);

    Productcolour selectByPrimaryKey(Integer productcolourid);

    int updateByPrimaryKeySelective(Productcolour record);

    int updateByPrimaryKey(Productcolour record);
    
    List<ProductcolourCustom> findProductColorAndSize(Integer productId);
    
    /**
     * 根据产品id删除颜色以及型号
     * @param productId
     * @return
     */
    int deleteColorByProductId(Integer productId);
}