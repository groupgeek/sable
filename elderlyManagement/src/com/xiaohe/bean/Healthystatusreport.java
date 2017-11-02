package com.xiaohe.bean;

public class Healthystatusreport {
    private Integer healthystatusid;

    private Integer countperson;

    private Integer branchid;

    private String nowmedicalrecords;

    public Integer getHealthystatusid() {
        return healthystatusid;
    }

    public void setHealthystatusid(Integer healthystatusid) {
        this.healthystatusid = healthystatusid;
    }

    public Integer getCountperson() {
        return countperson;
    }

    public void setCountperson(Integer countperson) {
        this.countperson = countperson;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getNowmedicalrecords() {
        return nowmedicalrecords;
    }

    public void setNowmedicalrecords(String nowmedicalrecords) {
        this.nowmedicalrecords = nowmedicalrecords == null ? null : nowmedicalrecords.trim();
    }
}