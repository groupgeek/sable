package com.xiaohe.bean;

import java.math.BigDecimal;

public class CeoProducttransactionreport extends Producttransactionreport{
	
	private BigDecimal getprice;
	private BigDecimal toprice;
	private String stringTime;
	private String summoney;
	private String sumBuy;
	private String sumgetprice;
	private String sumtoprice;
	private String stringDate;
	private String buynum;
	private String getpricenum;
	private String topricenum;
	private String buyString;
	private String sumtotalPrice;
	private String sumtotalExpenditure;
	private String dateString;
	private Integer branchid;
	private String productname;
	private BigDecimal price;
	private String branchname;
	
	private String sort;  //排序
	private Integer begin;
	private Integer pageNum;
	private String search;
	private Integer currentPage;

	
	
	
	@Override
	public String toString() {
		return "CeoProducttransactionreport [getprice=" + getprice
				+ ", toprice=" + toprice + ", stringTime=" + stringTime
				+ ", summoney=" + summoney + ", sumBuy=" + sumBuy
				+ ", sumgetprice=" + sumgetprice + ", sumtoprice=" + sumtoprice
				+ ", stringDate=" + stringDate + ", buynum=" + buynum
				+ ", getpricenum=" + getpricenum + ", topricenum=" + topricenum
				+ ", buyString=" + buyString + ", sumtotalPrice="
				+ sumtotalPrice + ", sumtotalExpenditure="
				+ sumtotalExpenditure + ", dateString=" + dateString
				+ ", branchid=" + branchid + ", productname=" + productname
				+ ", price=" + price + ", branchname=" + branchname + ", sort="
				+ sort + ", begin=" + begin + ", pageNum=" + pageNum
				+ ", search=" + search + ", currentPage=" + currentPage + "]";
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

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

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
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

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getBuyString() {
		return buyString;
	}

	public void setBuyString(String buyString) {
		this.buyString = buyString;
	}

	public String getSumtotalPrice() {
		return sumtotalPrice;
	}

	public void setSumtotalPrice(String sumtotalPrice) {
		this.sumtotalPrice = sumtotalPrice;
	}

	public String getSumtotalExpenditure() {
		return sumtotalExpenditure;
	}

	public void setSumtotalExpenditure(String sumtotalExpenditure) {
		this.sumtotalExpenditure = sumtotalExpenditure;
	}

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String getStringDate() {
		return stringDate;
	}

	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}

	public String getBuynum() {
		return buynum;
	}

	public void setBuynum(String buynum) {
		this.buynum = buynum;
	}

	public String getGetpricenum() {
		return getpricenum;
	}

	public void setGetpricenum(String getpricenum) {
		this.getpricenum = getpricenum;
	}

	public String getTopricenum() {
		return topricenum;
	}

	public void setTopricenum(String topricenum) {
		this.topricenum = topricenum;
	}

	public String getSumBuy() {
		return sumBuy;
	}

	public void setSumBuy(String sumBuy) {
		this.sumBuy = sumBuy;
	}

	public String getSumgetprice() {
		return sumgetprice;
	}

	public void setSumgetprice(String sumgetprice) {
		this.sumgetprice = sumgetprice;
	}

	public String getSumtoprice() {
		return sumtoprice;
	}

	public void setSumtoprice(String sumtoprice) {
		this.sumtoprice = sumtoprice;
	}

	public String getSummoney() {
		return summoney;
	}

	public void setSummoney(String summoney) {
		this.summoney = summoney;
	}

	public String getStringTime() {
		return stringTime;
	}

	public void setStringTime(String stringTime) {
		this.stringTime = stringTime;
	}

	public BigDecimal getGetprice() {
		return getprice;
	}

	public void setGetprice(BigDecimal getprice) {
		this.getprice = getprice;
	}

	public BigDecimal getToprice() {
		return toprice;
	}

	public void setToprice(BigDecimal toprice) {
		this.toprice = toprice;
	}

}
