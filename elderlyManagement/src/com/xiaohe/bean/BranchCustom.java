package com.xiaohe.bean;

public class BranchCustom extends Branch {
	
	private String employeename;
	private Integer profit;
	private String areaname;
	private String areaaddress;
	
	private Integer currentPage;
	private Integer pageNum;//每一页的数量
	private String sort;
	private String search;
	private Integer begin;
	
	private Integer usernum;
	private Integer employeenum;
	

	public Integer getUsernum() {
		return usernum;
	}

	public void setUsernum(Integer usernum) {
		this.usernum = usernum;
	}

	public Integer getEmployeenum() {
		return employeenum;
	}

	public void setEmployeenum(Integer employeenum) {
		this.employeenum = employeenum;
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

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getProfit() {
		return profit;
	}

	public void setProfit(Integer profit) {
		this.profit = profit;
	}

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}

	public String getAreaaddress() {
		return areaaddress;
	}

	public void setAreaaddress(String areaaddress) {
		this.areaaddress = areaaddress;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}
	

}
