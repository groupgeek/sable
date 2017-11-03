package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CeoTotalreport extends Totalreport{

	private Integer id;

    private BigDecimal totalprice;

    private BigDecimal totalexpenditure;

    private Integer branchid;

    private Date duringtime;
    
    private String branchname;

    private Integer areaid;

    private Integer employeeid;
    
    private BigDecimal sumBigDecimal;

	public BigDecimal getSumBigDecimal() {
		return sumBigDecimal;
	}

	public void setSumBigDecimal(BigDecimal sumBigDecimal) {
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

	@Override
	public String toString() {
		return "CeoTotalreport [id=" + id + ", totalprice=" + totalprice
				+ ", totalexpenditure=" + totalexpenditure + ", branchid="
				+ branchid + ", duringtime=" + duringtime + ", branchname="
				+ branchname + ", areaid=" + areaid + ", employeeid="
				+ employeeid + "]";
	}
    
}
