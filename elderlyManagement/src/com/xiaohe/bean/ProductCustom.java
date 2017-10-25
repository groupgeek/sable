package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.List;

public class ProductCustom extends Product {
	private Integer begin;//开始
	private Integer total;//每一页的条数
	private Integer areaid;
	private String sort;//排序的方式
	private String producttypename;
	private String search;
	private Integer currentPage;
	private BigDecimal countPrice;
	private Integer branchid;
	private int countBuy;
	private int employeeid;
	
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public Integer getBranchid() {
		return branchid;
	}
	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}
	
	public BigDecimal getCountPrice() {
		return countPrice;
	}
	public void setCountPrice(BigDecimal countPrice) {
		this.countPrice = countPrice;
	}
	public int getCountBuy() {
		return countBuy;
	}
	public void setCountBuy(int countBuy) {
		this.countBuy = countBuy;
	}
	private List<ProducttasteCustom> tasteList;
	private List<ProductcolourCustom> colourList;
	
	
	public List<ProductcolourCustom> getColourList() {
		return colourList;
	}
	public void setColourList(List<ProductcolourCustom> colourList) {
		this.colourList = colourList;
	}
	public List<ProducttasteCustom> getTasteList() {
		return tasteList;
	}
	public void setTasteList(List<ProducttasteCustom> tasteList) {
		this.tasteList = tasteList;
	}
	
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getProducttypename() {
		return producttypename;
	}
	public void setProducttypename(String producttypename) {
		this.producttypename = producttypename;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public Integer getAreaid() {
		return areaid;
	}
	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}

}