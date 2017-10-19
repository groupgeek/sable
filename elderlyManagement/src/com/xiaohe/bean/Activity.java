package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Activity {
    private Integer activityid;

    private String activityname;

    private Integer activitytypeid;

    private Boolean online;

    private String activitypicture;

    private String activitystatus;

    private Date activitydate;

    private Integer branchid;

    private BigDecimal registeryfee;

    private BigDecimal activityprice;

    private String activitydetails;

    public Integer getActivityid(){
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getActivityname() {
        return activityname;
    }

    public void setActivityname(String activityname) {
        this.activityname = activityname == null ? null : activityname.trim();
    }

    public Integer getActivitytypeid() {
        return activitytypeid;
    }

    public void setActivitytypeid(Integer activitytypeid) {
        this.activitytypeid = activitytypeid;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public String getActivitypicture() {
        return activitypicture;
    }

    public void setActivitypicture(String activitypicture) {
        this.activitypicture = activitypicture == null ? null : activitypicture.trim();
    }

    public String getActivitystatus() {
        return activitystatus;
    }

    public void setActivitystatus(String activitystatus) {
        this.activitystatus = activitystatus == null ? null : activitystatus.trim();
    }

    public Date getActivitydate() {
        return activitydate;
    }

    public void setActivitydate(Date activitydate) {
        this.activitydate = activitydate;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public BigDecimal getRegisteryfee() {
        return registeryfee;
    }

    public void setRegisteryfee(BigDecimal registeryfee) {
        this.registeryfee = registeryfee;
    }

    @Override
	public String toString() {
		return "Activity [activityid=" + activityid + ", activityname="
				+ activityname + ", activitytypeid=" + activitytypeid
				+ ", online=" + online + ", activitypicture=" + activitypicture
				+ ", activitystatus=" + activitystatus + ", activitydate="
				+ activitydate + ", branchid=" + branchid + ", registeryfee="
				+ registeryfee + ", activityprice=" + activityprice
				+ ", activitydetails=" + activitydetails + "]";
	}

	public BigDecimal getActivityprice() {
        return activityprice;
    }

    public void setActivityprice(BigDecimal activityprice) {
        this.activityprice = activityprice;
    }

    public String getActivitydetails() {
        return activitydetails;
    }

    public void setActivitydetails(String activitydetails) {
        this.activitydetails = activitydetails == null ? null : activitydetails.trim();
    }
}