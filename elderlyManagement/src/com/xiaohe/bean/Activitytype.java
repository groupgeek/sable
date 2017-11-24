package com.xiaohe.bean;

public class Activitytype {
    private Integer activitytypeid;

    private String activitytypename;

    private Integer fathertypeid;

    public Integer getActivitytypeid() {
        return activitytypeid;
    }

    public void setActivitytypeid(Integer activitytypeid) {
        this.activitytypeid = activitytypeid;
    }

    public String getActivitytypename() {
        return activitytypename;
    }

    public void setActivitytypename(String activitytypename) {
        this.activitytypename = activitytypename == null ? null : activitytypename.trim();
    }

    public Integer getFathertypeid() {
        return fathertypeid;
    }

    public void setFathertypeid(Integer fathertypeid) {
        this.fathertypeid = fathertypeid;
    }
}