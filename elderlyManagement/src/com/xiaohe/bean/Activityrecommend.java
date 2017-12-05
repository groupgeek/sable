package com.xiaohe.bean;

public class Activityrecommend {
    private Integer reid;

    private Integer activityid;

    private Integer branchid;

    private String websitetype;

    private Integer activitytypefatherid;

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getWebsitetype() {
        return websitetype;
    }

    public void setWebsitetype(String websitetype) {
        this.websitetype = websitetype == null ? null : websitetype.trim();
    }

    public Integer getActivitytypefatherid() {
        return activitytypefatherid;
    }

    public void setActivitytypefatherid(Integer activitytypefatherid) {
        this.activitytypefatherid = activitytypefatherid;
    }
}