package com.xiaohe.bean;

public class Userlevelreport {
    private Integer id;

    private String level;

    private Integer countperson;

    private Integer branchid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
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
}