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

    private String status;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}