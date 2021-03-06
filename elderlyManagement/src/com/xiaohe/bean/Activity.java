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

    private String video;

    private BigDecimal activityprice;

    private Integer maxnum;

    private Integer principalid;

    private Integer lecturerid;

    private String activitydetails;

    public Integer getActivityid() {
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public BigDecimal getActivityprice() {
        return activityprice;
    }

    public void setActivityprice(BigDecimal activityprice) {
        this.activityprice = activityprice;
    }

    public Integer getMaxnum() {
        return maxnum;
    }

    public void setMaxnum(Integer maxnum) {
        this.maxnum = maxnum;
    }

    public Integer getPrincipalid() {
        return principalid;
    }

    public void setPrincipalid(Integer principalid) {
        this.principalid = principalid;
    }

    public Integer getLecturerid() {
        return lecturerid;
    }

    public void setLecturerid(Integer lecturerid) {
        this.lecturerid = lecturerid;
    }

    public String getActivitydetails() {
        return activitydetails;
    }

    public void setActivitydetails(String activitydetails) {
        this.activitydetails = activitydetails == null ? null : activitydetails.trim();
    }
}