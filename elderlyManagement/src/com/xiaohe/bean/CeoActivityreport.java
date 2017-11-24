package com.xiaohe.bean;

import java.math.BigDecimal;

public class CeoActivityreport extends Activityreport{
	private String activityname;
	private String stringDate;
	private String branchname;
	private Integer activityid;
	private BigDecimal onlyget;
	private Integer branchid;
	
	private BigDecimal sumgetprice;
	private BigDecimal sumtoprice;
	private BigDecimal sumtotalPrice;
	private BigDecimal sumtotalExpenditure;
	
	private String sortofactivity;  //排序
	private Integer begin;
	private Integer pageNumofact;
	private String searchofact;
	private Integer currentPageofactivity;

	public BigDecimal getSumtotalPrice() {
		return sumtotalPrice;
	}

	public void setSumtotalPrice(BigDecimal sumtotalPrice) {
		this.sumtotalPrice = sumtotalPrice;
	}

	public BigDecimal getSumtotalExpenditure() {
		return sumtotalExpenditure;
	}

	public void setSumtotalExpenditure(BigDecimal sumtotalExpenditure) {
		this.sumtotalExpenditure = sumtotalExpenditure;
	}

	public BigDecimal getSumgetprice() {
		return sumgetprice;
	}

	public void setSumgetprice(BigDecimal sumgetprice) {
		this.sumgetprice = sumgetprice;
	}

	public BigDecimal getSumtoprice() {
		return sumtoprice;
	}

	public void setSumtoprice(BigDecimal sumtoprice) {
		this.sumtoprice = sumtoprice;
	}

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public String getSortofactivity() {
		return sortofactivity;
	}

	public void setSortofactivity(String sortofactivity) {
		this.sortofactivity = sortofactivity;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getPageNumofact() {
		return pageNumofact;
	}

	public void setPageNumofact(Integer pageNumofact) {
		this.pageNumofact = pageNumofact;
	}

	public String getSearchofact() {
		return searchofact;
	}

	public void setSearchofact(String searchofact) {
		this.searchofact = searchofact;
	}

	public Integer getCurrentPageofactivity() {
		return currentPageofactivity;
	}

	public void setCurrentPageofactivity(Integer currentPageofactivity) {
		this.currentPageofactivity = currentPageofactivity;
	}

	public BigDecimal getOnlyget() {
		return onlyget;
	}

	public void setOnlyget(BigDecimal onlyget) {
		this.onlyget = onlyget;
	}

	public Integer getActivityid() {
		return activityid;
	}

	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getStringDate() {
		return stringDate;
	}

	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}

	public String getActivityname() {
		return activityname;
	}

	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}
	
}
