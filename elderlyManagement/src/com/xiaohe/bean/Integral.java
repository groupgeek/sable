package com.xiaohe.bean;

import java.util.Date;

public class Integral {
    private Integer integralid;

    private Integer userid;

    private String details;

    private Integer change;

    private Date changetime;

    private Integer remainingpoints;

    public Integer getIntegralid() {
        return integralid;
    }

    public void setIntegralid(Integer integralid) {
        this.integralid = integralid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    public Integer getChange() {
        return change;
    }

    public void setChange(Integer change) {
        this.change = change;
    }

    public Date getChangetime() {
        return changetime;
    }

    public void setChangetime(Date changetime) {
        this.changetime = changetime;
    }

    public Integer getRemainingpoints() {
        return remainingpoints;
    }

    public void setRemainingpoints(Integer remainingpoints) {
        this.remainingpoints = remainingpoints;
    }
}