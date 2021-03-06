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
	
	
	private String []buyTime;
	private Integer []buyNo;
	private Date time;
	private Date nextDay;
	private Date start;
	private Date end;
	
	//用来接收时间的字符串
	private String startDateString;
	private String endDateString;
	
	private BigDecimal totalSail; //总销售额
	private BigDecimal oneSail;   //单个商品销售额
	public BigDecimal[] getCountBuy() {
		return countBuy;
	}

	public void setCountBuy(BigDecimal[] countBuy) {
		this.countBuy = countBuy;
	}

	private BigDecimal []countBuy;  //销售额数组
	private BigDecimal []countSail; //第二个销售额数组
	
	public BigDecimal[] getCountSail() {
		return countSail;
	}

	public void setCountSail(BigDecimal[] countSail) {
		this.countSail = countSail;
	}

	public BigDecimal getTotalSail() {
		return totalSail;
	}

	public void setTotalSail(BigDecimal totalSail) {
		this.totalSail = totalSail;
	}

	public BigDecimal getOneSail() {
		return oneSail;
	}

	public void setOneSail(BigDecimal oneSail) {
		this.oneSail = oneSail;
	}

	public String getStartDateString() {
		return startDateString;
	}

	public void setStartDateString(String startDateString) {
		this.startDateString = startDateString;
	}

	public String getEndDateString() {
		return endDateString;
	}

	public void setEndDateString(String endDateString) {
		this.endDateString = endDateString;
	}

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
