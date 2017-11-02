package com.xiaohe.bean;

public class EmployeeCustom extends Employee{
	
	private Integer age;
	private Integer entryYears;
	
	private Integer branchId;
	
	private String branchName;
	
	private Integer begin;
	private Integer pageNum;//每一页的数量
	private Integer currentPage;
	private Integer total;//总条数
	private String search;
	private String sort;
	
	private BranchCustom branch;
	private AreaCustom area;
	private AuthorityCustom authority;
	private PositionalCustom positional;

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
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

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getEntryYears() {
		return entryYears;
	}

	public void setEntryYears(Integer entryYears) {
		this.entryYears = entryYears;
	}

	public BranchCustom getBranch() {
		return branch;
	}

	public void setBranch(BranchCustom branch) {
		this.branch = branch;
	}

	public AreaCustom getArea() {
		return area;
	}

	public void setArea(AreaCustom area) {
		this.area = area;
	}

	public AuthorityCustom getAuthority() {
		return authority;
	}

	public void setAuthority(AuthorityCustom authority) {
		this.authority = authority;
	}

	public PositionalCustom getPositional() {
		return positional;
	}

	public void setPositional(PositionalCustom positional) {
		this.positional = positional;
	}
	

}
