package com.xiaohe.bean;

import java.math.BigDecimal;

public class ActivityrecommendCustom extends Activityrecommend {
	public String activityname;
	private String activitypicture;
	private BigDecimal registeryfee;
	public BigDecimal getRegisteryfee() {
		return registeryfee;
	}

	public void setRegisteryfee(BigDecimal registeryfee) {
		this.registeryfee = registeryfee;
	}

	public String getActivitypicture() {
		return activitypicture;
	}

	public void setActivitypicture(String activitypicture) {
		this.activitypicture = activitypicture;
	}

	private Integer activityidRec;
	public Integer getActivityidRec() {
		return activityidRec;
	}

	public void setActivityidRec(Integer activityidRec) {
		this.activityidRec = activityidRec;
	}

	public String getActivityname() {
		return activityname;
	}

	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}
	
}
