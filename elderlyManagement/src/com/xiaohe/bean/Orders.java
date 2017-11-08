package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Orders {
    private String orderid;

    private Integer productid;

    private Integer userid;

    private String productname;

    private String username;

    private String resaddress;

    private Integer productnumber;

    private BigDecimal totalprice;

    private BigDecimal price;

    private Date ordertime;

    private Integer branchid;

    private String orderstatus;

    private String productstatus;

    private String phone;

    private String signstatus;

    private Boolean evaluationstatus;

    private Date paymenttime;

    private Date timeofarrival;

    private Date submissiontime;

    private String taste;

    private String colour;

    private String size;

    private String other;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getResaddress() {
        return resaddress;
    }

    public void setResaddress(String resaddress) {
        this.resaddress = resaddress == null ? null : resaddress.trim();
    }

    public Integer getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(Integer productnumber) {
        this.productnumber = productnumber;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getOrderstatus() {
        return orderstatus;
    }

    public void setOrderstatus(String orderstatus) {
        this.orderstatus = orderstatus == null ? null : orderstatus.trim();
    }

    public String getProductstatus() {
        return productstatus;
    }

    public void setProductstatus(String productstatus) {
        this.productstatus = productstatus == null ? null : productstatus.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getSignstatus() {
        return signstatus;
    }

    public void setSignstatus(String signstatus) {
        this.signstatus = signstatus == null ? null : signstatus.trim();
    }

    public Boolean getEvaluationstatus() {
        return evaluationstatus;
    }

    public void setEvaluationstatus(Boolean evaluationstatus) {
        this.evaluationstatus = evaluationstatus;
    }

    public Date getPaymenttime() {
        return paymenttime;
    }

    public void setPaymenttime(Date paymenttime) {
        this.paymenttime = paymenttime;
    }

    public Date getTimeofarrival() {
        return timeofarrival;
    }

    public void setTimeofarrival(Date timeofarrival) {
        this.timeofarrival = timeofarrival;
    }

    public Date getSubmissiontime() {
        return submissiontime;
    }

    public void setSubmissiontime(Date submissiontime) {
        this.submissiontime = submissiontime;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste == null ? null : taste.trim();
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour == null ? null : colour.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other == null ? null : other.trim();
    }
}