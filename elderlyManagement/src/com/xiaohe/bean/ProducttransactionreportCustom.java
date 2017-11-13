package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Arrays;
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
	private String buy;//String类型的购买时间
	
	private Integer currentPage; //当前页
	private Integer sum;
	
	private Integer productid;
	
	private String []buyTime;
	private Integer []buyNo;
	private Date time;
	private Date nextDay;
	private Date start;
	private Date end;
	
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Date getNextDay() {
		return nextDay;
	}

	public void setNextDay(Date nextDay) {
		this.nextDay = nextDay;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String[] getBuyTime() {
		return buyTime;
	}

	public void setBuyTime(String[] buyTime) {
		this.buyTime = buyTime;
	}

	public Integer[] getBuyNo() {
		return buyNo;
	}

	public void setBuyNo(Integer[] buyNo) {
		this.buyNo = buyNo;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String getBuy() {
		return buy;
	}

	public void setBuy(String buy) {
		this.buy = buy;
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
