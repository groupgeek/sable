package com.xiaohe.bean;

import java.util.List;

public class ProductCustom extends Product {
	private Integer begin;//开始
	private Integer total;//每一页的条数
	private Integer areaid;
	private String sort;//排序的方式
	private String producttypename;
	private String search;
	private Integer currentPage;
	
	
	private List<ProducttasteCustom> tasteList;
	private List<ProductcolourCustom> colourList;
	private Integer employeeid;
	private Integer pageNum;//每一页的数量
	private String branchname;
	
	private String employeename;
	private String fathertype;
	private Integer fathertypeid;
	
	private String tasteString;
	private String colorString;
	
	
	
	
	public String getTasteString() {
		return tasteString;
	}
	public void setTasteString(String tasteString) {
		this.tasteString = tasteString;
	}
	public String getColorString() {
		return colorString;
	}
	public void setColorString(String colorString) {
		this.colorString = colorString;
	}
	public String getFathertype() {
		return fathertype;
	}
	public void setFathertype(String fathertype) {
		this.fathertype = fathertype;
	}
	public String getEmployeename() {
		return employeename;
	}
	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	public Integer getFathertypeid() {
		return fathertypeid;
	}
	public void setFathertypeid(Integer fathertypeid) {
		this.fathertypeid = fathertypeid;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
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