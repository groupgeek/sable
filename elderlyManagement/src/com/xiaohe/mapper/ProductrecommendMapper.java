package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.ProductCustom;
import com.xiaohe.bean.Productrecommend;
import com.xiaohe.bean.ProductrecommendCustom;
import com.xiaohe.bean.UserCustom;

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
    
    /**
     * 根据分店id和商品id查到对应的推荐商品
     * @param productCustom
     * @return
     */
    ProductrecommendCustom oneProductRec(ProductrecommendCustom productCustom);
    
    /**
     * 查询推荐商品数量
     * @return
     */
    int countProductRec(Integer id);
    /**
     * t推荐统计
     * @param branchid
     * @return
     */
    Integer sumRecommendProduct(Integer branchid);

    /**
     * 用户推荐查询
     * @param phone
     * @return 返回用户信息
     */
    UserCustom quertyuserProduct(String  phone);
    
    List<ProductCustom> quertyRecommendingProduct(Integer branchid);
    
}