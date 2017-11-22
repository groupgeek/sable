package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Date;

public class ActivityCustom extends Activity {

	/**
	 * 扩展类
	 * begin total ：：sql limit begin, total
	 * introduction 简介
	 */
	private Integer begin;
	private Integer total;//每一页显示多少条
	private String introduction;
	private String websitetype;
	private Integer countUsers;
	private String branchname;
	private String username;
	private String avatar;
	

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	private Integer currentPage;
	private Integer pageNum;//每一页的数量
	private String sort;
	private String search;
	
	private String fathertypename;
	private Integer fathertypeid;
	private String activitytypename;
	
	private String activitydateString;
	private String registery;
	private BigDecimal totalReg;   //总报名费（报表）
	private BigDecimal totalExpend;  //总支出费用（报表）
	
	private Integer userid;
	
	private Date start;
	private Date end;
	
	
	
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getRegistery() {
		return registery;
	}
	public void setRegistery(String registery) {
		this.registery = registery;
	}
	public BigDecimal getTotalReg() {
		return totalReg;
	}
	public void setTotalReg(BigDecimal totalReg) {
		this.totalReg = totalReg;
	}
	public BigDecimal getTotalExpend() {
		return totalExpend;
	}
	public void setTotalExpend(BigDecimal totalExpend) {
		this.totalExpend = totalExpend;
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
	public BigDecimal[] getIncomeReport() {
		return incomeReport;
	}
	public void setIncomeReport(BigDecimal[] incomeReport) {
		this.incomeReport = incomeReport;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	public BigDecimal getDemo1() {
		return demo1;
	}
	public void setDemo1(BigDecimal demo1) {
		this.demo1 = demo1;
	}
	public BigDecimal getDemo2() {
		return demo2;
	}
	public void setDemo2(BigDecimal demo2) {
		this.demo2 = demo2;
	}
	public BigDecimal getTotalexl() {
		return totalexl;
	}
	public void setTotalexl(BigDecimal totalexl) {
		this.totalexl = totalexl;
	}
	public BigDecimal getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(BigDecimal totalIncome) {
		this.totalIncome = totalIncome;
	}
	private BigDecimal[] incomeReport;
	private Integer employeeid;
	private BigDecimal demo1;
	private BigDecimal demo2;
	private BigDecimal totalexl;     //总支出
	private BigDecimal totalIncome;  //总收入
	private int countReg;   //总报名人数
	
	public int getCountReg() {
		return countReg;
	}
	public void setCountReg(int countReg) {
		this.countReg = countReg;
	}
	public String getActivitydateString() {
		return activitydateString;
	}
	public void setActivitydateString(String activitydateString) {
		this.activitydateString = activitydateString;
	}
	public String getActivitytypename() {
		return activitytypename;
	}
	public void setActivitytypename(String activitytypename) {
		this.activitytypename = activitytypename;
	}
	public String getFathertypename() {
		return fathertypename;
	}
	public void setFathertypename(String fathertypename) {
		this.fathertypename = fathertypename;
	}
	public Integer getFathertypeid() {
		return fathertypeid;
	}
	public void setFathertypeid(Integer fathertypeid) {
		this.fathertypeid = fathertypeid;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
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
	public String getBranchname() {
		return branchname;
	}
	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}
	public Integer getCountUsers() {
		return countUsers;
	}
	public void setCountUsers(Integer countUsers) {
		this.countUsers = countUsers;
	}
	public String getWebsitetype() {
		return websitetype;
	}
	public void setWebsitetype(String websitetype) {
		this.websitetype = websitetype;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
