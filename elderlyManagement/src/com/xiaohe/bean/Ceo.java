package com.xiaohe.bean;

public class Ceo {
    private Integer ceoid;

    private Integer authorityid;

    private String password;

    public Integer getCeoid() {
        return ceoid;
    }

    public void setCeoid(Integer ceoid) {
        this.ceoid = ceoid;
    }

    public Integer getAuthorityid() {
        return authorityid;
    }

    public void setAuthorityid(Integer authorityid) {
        this.authorityid = authorityid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}