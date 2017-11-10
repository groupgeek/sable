package com.xiaohe.bean;

import java.util.List;

public class ShippingAddVo {
	private UserCustom user;
	private List<ShippingAddressCustom> addresssList;
	public UserCustom getUser() {
		return user;
	}
	public void setUser(UserCustom user) {
		this.user = user;
	}
	public List<ShippingAddressCustom> getAddresssList() {
		return addresssList;
	}
	public void setAddresssList(List<ShippingAddressCustom> addresssList) {
		this.addresssList = addresssList;
	}
	

}
