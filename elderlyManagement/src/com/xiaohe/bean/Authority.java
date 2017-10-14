package com.xiaohe.bean;

public class Authority {
    private Integer authorityid;

    private String authoritylevel;

    public Integer getAuthorityid() {
        return authorityid;
    }

    public void setAuthorityid(Integer authorityid) {
        this.authorityid = authorityid;
    }

    public String getAuthoritylevel() {
        return authoritylevel;
    }

    public void setAuthoritylevel(String authoritylevel) {
        this.authoritylevel = authoritylevel == null ? null : authoritylevel.trim();
    }
}