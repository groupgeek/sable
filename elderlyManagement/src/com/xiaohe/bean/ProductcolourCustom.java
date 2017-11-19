package com.xiaohe.bean;

import java.util.List;

public class ProductcolourCustom extends Productcolour {
	private String productName;
	private Double price;
	 private String picture;
	 private String size;
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	private List<ProductcoloursizeCustom> colourSizeList;
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}



	public List<ProductcoloursizeCustom> getColourSizeList() {
		return colourSizeList;
	}

	public void setColourSizeList(List<ProductcoloursizeCustom> colourSizeList) {
		this.colourSizeList = colourSizeList;
	}

	@Override
	public String toString() {
		return "ProductcolourCustom [productName=" + productName + ", price="
				+ price + ", colourSizeList=" + colourSizeList
				+ ", getProductcolourid()=" + getProductcolourid()
				+ ", getProductid()=" + getProductid()
				+ ", getProductcolour()=" + getProductcolour()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	

}
