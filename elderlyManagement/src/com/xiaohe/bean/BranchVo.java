package com.xiaohe.bean;

import java.util.List;

public class BranchVo {
	private Integer pageSum;//总页数
	private Integer branchSum;
	private List<BranchCustom> branchList;
	private List<EmployeeCustom> employeeList;
	private BranchCustom branch;
	private List<AreaCustom> allArea;
	
	
	public List<AreaCustom> getAllArea() {
		return allArea;
	}
	public void setAllArea(List<AreaCustom> allArea) {
		this.allArea = allArea;
	}
	public BranchCustom getBranch() {
		return branch;
	}
	public void setBranch(BranchCustom branch) {
		this.branch = branch;
	}
	public List<EmployeeCustom> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmployeeCustom> employeeList) {
		this.employeeList = employeeList;
	}
	public Integer getPageSum() {
		return pageSum;
	}
	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}
	public Integer getBranchSum() {
		return branchSum;
	}
	public void setBranchSum(Integer branchSum) {
		this.branchSum = branchSum;
	}
	public List<BranchCustom> getBranchList() {
		return branchList;
	}
	public void setBranchList(List<BranchCustom> branchList) {
		this.branchList = branchList;
	}
	
}
