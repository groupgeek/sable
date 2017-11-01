package com.xiaohe.bean;

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
	

	private Integer currentPage;
	private Integer pageNum;//每一页的数量
	private String sort;
	private String search;
	
	private String fathertypename;
	private Integer fathertypeid;
	private String activitytypename;
	
	
	
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
