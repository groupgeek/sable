package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Activityreport {
    private Integer activityreporid;

    private Integer activitytypeid;

    private Integer countactivity;

    private Boolean online;

    private Integer averagepeople;

    private Integer branchid;

    private Date duringtime;

    private BigDecimal totalprice;

    private BigDecimal totalexpenditure;

    public Integer getActivityreporid() {
        return activityreporid;
    }

    public void setActivityreporid(Integer activityreporid) {
        this.activityreporid = activityreporid;
    }

    public Integer getActivitytypeid() {
        return activitytypeid;
    }

    public void setActivitytypeid(Integer activitytypeid) {
        this.activitytypeid = activitytypeid;
    }

    public Integer getCountactivity() {
        return countactivity;
    }

    public void setCountactivity(Integer countactivity) {
        this.countactivity = countactivity;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

    public Integer getAveragepeople() {
        return averagepeople;
    }

    public void setAveragepeople(Integer averagepeople) {
        this.averagepeople = averagepeople;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public Date getDuringtime() {
        return duringtime;
    }

    public void setDuringtime(Date duringtime) {
        this.duringtime = duringtime;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public BigDecimal getTotalexpenditure() {
        return totalexpenditure;
    }

    public void setTotalexpenditure(BigDecimal totalexpenditure) {
        this.totalexpenditure = totalexpenditure;
    }
}