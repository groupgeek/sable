package com.xiaohe.bean;

import java.util.List;

public class UserVo {
	private Integer pageSum;//总页数
	private Integer userSum;
	private List<UserCustom> userList;
	public Integer getPageSum() {
		return pageSum;
	}
	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}
	public List<UserCustom> getUserList() {
		return userList;
	}
	public void setUserList(List<UserCustom> userList) {
		this.userList = userList;
	}
	public Integer getUserSum() {
		return userSum;
	}
	public void setUserSum(Integer userSum) {
		this.userSum = userSum;
	}
}
