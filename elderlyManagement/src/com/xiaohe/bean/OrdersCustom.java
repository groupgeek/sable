package com.xiaohe.bean;

import java.util.Date;

public class OrdersCustom extends Orders {
	private ProductCustom productInfo;
	private ProducttasteCustom producttasteInfo;
	private ProductcolourCustom productcolourInfo;
	private Integer type;//商品分类
	
	
	
	private String paymenttimeString;

    private String timeofarrivalString;

    private String submissiontimeString;
    
    private String ordertimeString;
    
	
    private String picture;
	private String description;
	
	
	
	public String getPaymenttimeString() {
		return paymenttimeString;
	}
	public void setPaymenttimeString(String paymenttimeString) {
		this.paymenttimeString = paymenttimeString;
	}
	public String getTimeofarrivalString() {
		return timeofarrivalString;
	}
	public void setTimeofarrivalString(String timeofarrivalString) {
		this.timeofarrivalString = timeofarrivalString;
	}
	public String getSubmissiontimeString() {
		return submissiontimeString;
	}
	public void setSubmissiontimeString(String submissiontimeString) {
		this.submissiontimeString = submissiontimeString;
	}
	public String getOrdertimeString() {
		return ordertimeString;
	}
	public void setOrdertimeString(String ordertimeString) {
		this.ordertimeString = ordertimeString;
	}
	
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductCustom getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ProductCustom productInfo) {
		this.productInfo = productInfo;
	}
	public ProducttasteCustom getProducttasteInfo() {
		return producttasteInfo;
	}
	public void setProducttasteInfo(ProducttasteCustom producttasteInfo) {
		this.producttasteInfo = producttasteInfo;
	}
	public ProductcolourCustom getProductcolourInfo() {
		return productcolourInfo;
	}
	public void setProductcolourInfo(ProductcolourCustom productcolourInfo) {
		this.productcolourInfo = productcolourInfo;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	

}
