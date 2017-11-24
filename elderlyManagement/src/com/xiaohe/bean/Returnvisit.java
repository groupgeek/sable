package com.xiaohe.bean;

import java.util.Date;

public class Returnvisit {
    private Integer returnvisitid;

    private Integer userid;

    private String username;

    private String address;

    private Date lastvisttime;

    private Integer countvisit;

    public Integer getReturnvisitid() {
        return returnvisitid;
    }

    public void setReturnvisitid(Integer returnvisitid) {
        this.returnvisitid = returnvisitid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getLastvisttime() {
        return lastvisttime;
    }

    public void setLastvisttime(Date lastvisttime) {
        this.lastvisttime = lastvisttime;
    }

    public Integer getCountvisit() {
        return countvisit;
    }

    public void setCountvisit(Integer countvisit) {
        this.countvisit = countvisit;
    }
}