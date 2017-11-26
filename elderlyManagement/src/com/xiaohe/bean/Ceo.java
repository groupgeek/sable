package com.xiaohe.bean;

public class Ceo {
    private Integer ceoid;

    private Integer authorityid;

    private String password;

    private String ceoaccountnumber;

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

    public String getCeoaccountnumber() {
        return ceoaccountnumber;
    }

    public void setCeoaccountnumber(String ceoaccountnumber) {
        this.ceoaccountnumber = ceoaccountnumber == null ? null : ceoaccountnumber.trim();
    }
}