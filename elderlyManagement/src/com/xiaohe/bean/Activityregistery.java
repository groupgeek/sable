package com.xiaohe.bean;

public class Activityregistery extends ActivityregisteryKey {
    private String registery;

    public String getRegistery() {
        return registery;
    }

    public void setRegistery(String registery) {
        this.registery = registery == null ? null : registery.trim();
    }
}