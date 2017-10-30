package com.xiaohe.bean;

import java.util.List;

public class ActivityVo {
	private Integer pageSum;//总页数
	private Integer activitySum;//总条数
	private List<ActivityCustom> activityList;
	public Integer getPageSum() {
		return pageSum;
	}
	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}
	public List<ActivityCustom> getActivityList() {
		return activityList;
	}
	public void setActivityList(List<ActivityCustom> activityList) {
		this.activityList = activityList;
	}
	public Integer getActivitySum() {
		return activitySum;
	}
	public void setActivitySum(Integer activitySum) {
		this.activitySum = activitySum;
	}
	

}
