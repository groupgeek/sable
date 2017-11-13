package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ProducttransactionreportCustom extends Producttransactionreport {
	
	private String sort;//排序的方式
	private Integer totalCount;//总的购买次数
	private BigDecimal totalMoney;//总的钱
	private BigDecimal totalExpenses;//总的支出
	private Integer begin;
	private Integer pageNum;
	private Date startingTime;
	private Date endTime;
	private Integer employeeid;
	private String productname;
	private Integer pagesum;
	private BigDecimal getprice;
	private BigDecimal toprice;
	private String stringTime;
	private String summoney;

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

	public Integer getPagesum() {
		return pagesum;
	}

	public void setPagesum(Integer pagesum) {
		this.pagesum = pagesum;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Date getStartingTime() {
		return startingTime;
	}

	public void setStartingTime(Date startingTime) {
		this.startingTime = startingTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public BigDecimal getTotalExpenses() {
		return totalExpenses;
	}

	public void setTotalExpenses(BigDecimal totalExpenses) {
		this.totalExpenses = totalExpenses;
	}
	

}
