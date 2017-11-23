package com.xiaohe.bean;

import java.util.List;

public class CeoActivityreportVo {
	private Integer pageNumofact;//总页数
	private Integer activitySum;//总条数
	private List<CeoActivityreport> listactivity;

	public Integer getPageNumofact() {
		return pageNumofact;
	}
	public void setPageNumofact(Integer pageNumofact) {
		this.pageNumofact = pageNumofact;
	}
	public Integer getActivitySum() {
		return activitySum;
	}
	public void setActivitySum(Integer activitySum) {
		this.activitySum = activitySum;
	}
	public List<CeoActivityreport> getListactivity() {
		return listactivity;
	}
	public void setListactivity(List<CeoActivityreport> listactivity) {
		this.listactivity = listactivity;
	}
	
}
