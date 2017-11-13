package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.Productrecommend;

public interface ProductrecommendMapper {
    int deleteByPrimaryKey(Integer productrecommendid);

    int insert(Productrecommend record);

    int insertSelective(Productrecommend record);

    Productrecommend selectByPrimaryKey(Integer productrecommendid);

    int updateByPrimaryKeySelective(Productrecommend record);

    int updateByPrimaryKey(Productrecommend record);
    
    /**
     * 查询商品推荐表
     * @param userid
     * @return 商品集合
     */
    List<ProductCustom> selectProductrecommend(Integer userid);
    /**
     * 
     * @param branchid分店ID
     * @return 本店商品推荐
     */
    List<ProductCustom> quertyRecommendProdcut(Integer branchid);
    
}