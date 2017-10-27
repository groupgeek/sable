package com.xiaohe.bean;

public class UserCustom extends User{
	private String statusMessage;
	
	private Integer begin;
	private Integer pageNum;//每一页的数量
	private Integer currentPage;
	private Integer total;//总条数
	private String search;
	private Integer onLineNum;//在线人数
	private String sort;

	
	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Integer getOnLineNum() {
		return onLineNum;
	}

	public void setOnLineNum(Integer onLineNum) {
		this.onLineNum = onLineNum;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	

}
