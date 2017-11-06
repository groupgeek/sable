package com.xiaohe.bean;

public class ShoppingcarCustom extends Shoppingcar {
	private Integer type;
	private ProductCustom productInfo;
	
	private ProducttasteCustom producttasteInfo;
	private ProductcolourCustom productcolourInfo;
	
	

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

	public ProductCustom getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductCustom productInfo) {
		this.productInfo = productInfo;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	

}
