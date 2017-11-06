package com.xiaohe.bean;

public class AddShopCartVo {
	private Integer type;
	private Integer productid;
	private Integer number;
	private Integer taste;
	private Integer colour;
	private String size;
	private User user;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getTaste() {
		return taste;
	}
	public void setTaste(Integer taste) {
		this.taste = taste;
	}
	public Integer getColour() {
		return colour;
	}
	public void setColour(Integer colour) {
		this.colour = colour;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
}
