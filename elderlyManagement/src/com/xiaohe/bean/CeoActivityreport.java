package com.xiaohe.bean;

import java.math.BigDecimal;

public class CeoActivityreport extends Activityreport{
	private String activityname;
	private String stringDate;
	private String stringTime;
	private String branchname;
	private Integer activityid;
	private BigDecimal onlyget;
	private Integer branchid;
	
	private BigDecimal sumgetprice;
	private BigDecimal sumtoprice;
	private BigDecimal sumtotalPrice;
	private BigDecimal sumtotalExpenditure;
	private BigDecimal sumAllBigDecimal;
	private BigDecimal sumAlltoprice;
	private BigDecimal sumAllgetprice;
	private BigDecimal sumAllBigDecimalBranch;
	private BigDecimal sumAlltopriceBranch;
	private BigDecimal sumAllgetpriceBranch;
	
	private String sortofactivity;  //排序
	private Integer begin;
	private Integer pageNumofact;
	private String searchofact;
	private Integer currentPageofactivity;

	public String getStringTime() {
		return stringTime;
	}

	public void setStringTime(String stringTime) {
		this.stringTime = stringTime;
	}

	public BigDecimal getSumAllBigDecimalBranch() {
		return sumAllBigDecimalBranch;
	}

	public void setSumAllBigDecimalBranch(BigDecimal sumAllBigDecimalBranch) {
		this.sumAllBigDecimalBranch = sumAllBigDecimalBranch;
	}

	public BigDecimal getSumAlltopriceBranch() {
		return sumAlltopriceBranch;
	}

	public void setSumAlltopriceBranch(BigDecimal sumAlltopriceBranch) {
		this.sumAlltopriceBranch = sumAlltopriceBranch;
	}

	public BigDecimal getSumAllgetpriceBranch() {
		return sumAllgetpriceBranch;
	}

	public void setSumAllgetpriceBranch(BigDecimal sumAllgetpriceBranch) {
		this.sumAllgetpriceBranch = sumAllgetpriceBranch;
	}

	public BigDecimal getSumAllBigDecimal() {
		return sumAllBigDecimal;
	}

	public void setSumAllBigDecimal(BigDecimal sumAllBigDecimal) {
		this.sumAllBigDecimal = sumAllBigDecimal;
	}

	public BigDecimal getSumAlltoprice() {
		return sumAlltoprice;
	}

	public void setSumAlltoprice(BigDecimal sumAlltoprice) {
		this.sumAlltoprice = sumAlltoprice;
	}

	public BigDecimal getSumAllgetprice() {
		return sumAllgetprice;
	}

	public void setSumAllgetprice(BigDecimal sumAllgetprice) {
		this.sumAllgetprice = sumAllgetprice;
	}

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
