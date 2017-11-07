package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.Shoppingcar;
import com.xiaohe.bean.ShoppingcarCustom;

public interface ShoppingcarMapper {
    int deleteByPrimaryKey(Integer shoppingcarid);

    int insert(Shoppingcar record);

    int insertSelective(Shoppingcar record);

    Shoppingcar selectByPrimaryKey(Integer shoppingcarid);

    int updateByPrimaryKeySelective(Shoppingcar record);

    int updateByPrimaryKey(Shoppingcar record);
    
    /**
     * 根据用户查询购物车(食物)
     * @param userid
     * @return
     */
    List<ShoppingcarCustom> selectAllShopCartFoodByUserid(Integer userid);
    
    /**
     * 根据用户查询购物车(衣服)
     * @param userid
     * @return
     */
    List<ShoppingcarCustom> selectAllShopCartClothesByUserid(Integer userid);
    
    /**
     * 根据用户查询购物车(其他)
     * @param userid
     * @return
     */
    List<ShoppingcarCustom> selectAllShopCartOtherByUserid(Integer userid);
}