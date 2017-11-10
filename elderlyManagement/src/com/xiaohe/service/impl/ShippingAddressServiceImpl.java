package com.xiaohe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.xiaohe.mapper.ShippingaddressMapper;
import com.xiaohe.service.ShippingAddressService;

@Repository("shippingAddressService")
public class ShippingAddressServiceImpl implements ShippingAddressService {
	
	@Autowired
	@Qualifier("shippingaddressMapper")
	private ShippingaddressMapper shippingaddressMapper;

	public boolean deleteAddress(Integer shippingaddressid) {
		if(shippingaddressid == null) return false;
		if(shippingaddressMapper.deleteByPrimaryKey(shippingaddressid) <= 0) return false;
		return true;
	}

}
