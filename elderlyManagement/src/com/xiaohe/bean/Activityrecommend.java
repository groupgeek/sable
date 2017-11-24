package com.xiaohe.bean;

public class Activityrecommend extends ActivityrecommendKey {
    private String websitetype;

    public String getWebsitetype() {
        return websitetype;
    }

    public void setWebsitetype(String websitetype) {
        this.websitetype = websitetype == null ? null : websitetype.trim();
    }
}