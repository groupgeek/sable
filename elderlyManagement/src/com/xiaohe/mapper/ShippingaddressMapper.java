package com.xiaohe.mapper;

import java.util.List;

import com.xiaohe.bean.ShippingAddressCustom;
import com.xiaohe.bean.Shippingaddress;

public interface ShippingaddressMapper {
    int deleteByPrimaryKey(Integer shippingaddressid);

    int insert(Shippingaddress record);

    int insertSelective(Shippingaddress record);

    Shippingaddress selectByPrimaryKey(Integer shippingaddressid);

    int updateByPrimaryKeySelective(Shippingaddress record);

    int updateByPrimaryKey(Shippingaddress record);
    
    /**
     * 查询出某用户的所有收货地址
     * @param userid
     * @return
     */
    List<ShippingAddressCustom> selectAllAddressByUserid(Integer userid);
    
    /**
     * 查询用户的默认地址
     * @param userid
     * @return
     */
    ShippingAddressCustom selectDefaultAddressByByUserid(Integer userid);
    
}