package com.xiaohe.bean;

public class ProductCustom extends Product {
	private Integer begin;
	private Integer total;
	private Integer areaid;
	private String sort;
	private String producttypename;
	private String search;
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
