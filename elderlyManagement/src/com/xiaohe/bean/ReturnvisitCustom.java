package com.xiaohe.bean;

public class ReturnvisitCustom extends Returnvisit {
	private Integer begin;
	private String branchname;
	private Integer branchid;
	private Integer currentPage;
	private Integer pageNum;//每一页的数量
	private String sort;
	private String search;
	
	private String lastvisttimeString;
	
	public String getLastvisttimeString() {
		return lastvisttimeString;
	}
	public void setLastvisttimeString(String lastvisttimeString) {
		this.lastvisttimeString = lastvisttimeString;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public Integer getBranchid() {
		return branchid;
	}
	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
}
