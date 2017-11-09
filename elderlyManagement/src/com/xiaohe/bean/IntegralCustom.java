package com.xiaohe.bean;

public class IntegralCustom extends Integral {

	private Integer begin;
	private Integer pageNum;//每一页的数量
	private Integer currentPage;
	private Integer total;//总条数
	
	
	private String changetimeString;
	
	
	public String getChangetimeString() {
		return changetimeString;
	}
	public void setChangetimeString(String changetimeString) {
		this.changetimeString = changetimeString;
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
	
}
