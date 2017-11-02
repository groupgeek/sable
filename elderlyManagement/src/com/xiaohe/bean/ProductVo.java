package com.xiaohe.bean;

import java.util.List;

public class ProductVo {

	private Integer pageSum;//总页数
	private Integer productSum;
	private List<ProductCustom> productList;
	private List<ProducttypeCustom> fatherTypeList;
	private ProductCustom productInfo;
	
	
	public ProductCustom getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ProductCustom productInfo) {
		this.productInfo = productInfo;
	}
	public List<ProducttypeCustom> getFatherTypeList() {
		return fatherTypeList;
	}
	public void setFatherTypeList(List<ProducttypeCustom> fatherTypeList) {
		this.fatherTypeList = fatherTypeList;
	}
	public Integer getPageSum() {
		return pageSum;
	}
	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}
	public Integer getProductSum() {
		return productSum;
	}
	public void setProductSum(Integer productSum) {
		this.productSum = productSum;
	}
	public List<ProductCustom> getProductList() {
		return productList;
	}
	public void setProductList(List<ProductCustom> productList) {
		this.productList = productList;
	}
	
}
