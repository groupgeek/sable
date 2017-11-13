package com.xiaohe.bean;

public class Shippingaddress {
    private Integer shippingaddressid;

    private String shippingaddress;

    private Integer userid;

    private Boolean defaultaddress;

    private Integer phone;

    private String receiver;

    public Integer getShippingaddressid() {
        return shippingaddressid;
    }

    public void setShippingaddressid(Integer shippingaddressid) {
        this.shippingaddressid = shippingaddressid;
    }

    public String getShippingaddress() {
        return shippingaddress;
    }

    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress == null ? null : shippingaddress.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Boolean getDefaultaddress() {
        return defaultaddress;
    }

    public void setDefaultaddress(Boolean defaultaddress) {
        this.defaultaddress = defaultaddress;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver == null ? null : receiver.trim();
    }
}