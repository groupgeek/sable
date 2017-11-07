package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CeoTotalreport extends Totalreport{

	private Integer id;

    private BigDecimal totalprice;

    private BigDecimal totalexpenditure;

    private Integer branchid;

    private Date duringtime;
	private Date startingTime;
	private Date endTime;
    private String branchname;

    private Integer areaid;

    private Integer employeeid;
    
    private String sumBigDecimal;
    private String stringmoney;
    private String stringbigdecimal;
    private String listbigdecimal;
    
    private BigDecimal sumtotalprice;
    
    private BigDecimal sumtotalexpenditure;
	private String sort;
	private Integer begin;
	private Integer pageNum;
	private Integer pagesum;

	public String getSumBigDecimal() {
		return sumBigDecimal;
	}

	public void setSumBigDecimal(String sumBigDecimal) {
		this.sumBigDecimal = sumBigDecimal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(BigDecimal totalprice) {
		this.totalprice = totalprice;
	}

	public BigDecimal getTotalexpenditure() {
		return totalexpenditure;
	}

	public void setTotalexpenditure(BigDecimal totalexpenditure) {
		this.totalexpenditure = totalexpenditure;
	}

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public Date getDuringtime() {
		return duringtime;
	}

	public void setDuringtime(Date duringtime) {
		this.duringtime = duringtime;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public BigDecimal getSumtotalprice() {
		return sumtotalprice;
	}

	public void setSumtotalprice(BigDecimal sumtotalprice) {
		this.sumtotalprice = sumtotalprice;
	}

	public BigDecimal getSumtotalexpenditure() {
		return sumtotalexpenditure;
	}

	public void setSumtotalexpenditure(BigDecimal sumtotalexpenditure) {
		this.sumtotalexpenditure = sumtotalexpenditure;
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

	public Integer getPagesum() {
		return pagesum;
	}

	public void setPagesum(Integer pagesum) {
		this.pagesum = pagesum;
	}

	public String getStringbigdecimal() {
		return stringbigdecimal;
	}

	public void setStringbigdecimal(String stringbigdecimal) {
		this.stringbigdecimal = stringbigdecimal;
	}

	public String getStringmoney() {
		return stringmoney;
	}

	public void setStringmoney(String stringmoney) {
		this.stringmoney = stringmoney;
	}

	public String getListbigdecimal() {
		return listbigdecimal;
	}

	public void setListbigdecimal(String listbigdecimal) {
		this.listbigdecimal = listbigdecimal;
	}

}
