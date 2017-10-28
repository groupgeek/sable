package com.xiaohe.bean;

import java.util.List;

public class EmployeeVo {
	
	private Integer pageSum;//总页数
	private Integer employeeSum;
	private List<EmployeeCustom> employeeList;
	public Integer getPageSum() {
		return pageSum;
	}
	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}
	public Integer getEmployeeSum() {
		return employeeSum;
	}
	public void setEmployeeSum(Integer employeeSum) {
		this.employeeSum = employeeSum;
	}
	public List<EmployeeCustom> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmployeeCustom> employeeList) {
		this.employeeList = employeeList;
	}
	
}
