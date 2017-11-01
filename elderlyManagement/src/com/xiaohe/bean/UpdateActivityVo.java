package com.xiaohe.bean;

import java.util.List;

public class UpdateActivityVo {
	private ActivityCustom activityInfo;
	private List<BranchCustom> allBranch;
	private List<ActivitytypeCustom> allActivitytype;
	public ActivityCustom getActivityInfo() {
		return activityInfo;
	}
	public void setActivityInfo(ActivityCustom activityInfo) {
		this.activityInfo = activityInfo;
	}
	public List<BranchCustom> getAllBranch() {
		return allBranch;
	}
	public void setAllBranch(List<BranchCustom> allBranch) {
		this.allBranch = allBranch;
	}
	public List<ActivitytypeCustom> getAllActivitytype() {
		return allActivitytype;
	}
	public void setAllActivitytype(List<ActivitytypeCustom> allActivitytype) {
		this.allActivitytype = allActivitytype;
	}
	

}
