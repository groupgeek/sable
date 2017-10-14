package com.xiaohe.bean;

public class Activityrecommend {
    private Integer activityid;

    private String websitetype;

    public Integer getActivityid() {
        return activityid;
    }

    public void setActivityid(Integer activityid) {
        this.activityid = activityid;
    }

    public String getWebsitetype() {
        return websitetype;
    }

    public void setWebsitetype(String websitetype) {
        this.websitetype = websitetype == null ? null : websitetype.trim();
    }
}