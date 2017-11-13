package com.xiaohe.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ShippingAddressService {
	/**
	 * 删除地址
	 * @param id
	 * @return
	 */
	public boolean deleteAddress(Integer shippingaddressid);

}
