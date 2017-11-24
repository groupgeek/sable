package com.xiaohe.bean;

import java.math.BigDecimal;

public class Shoppingcar {
    private Integer shoppingcarid;

    private Integer userid;

    private Integer productid;

    private String productname;

    private BigDecimal price;

    private Integer taste;

    private Integer colour;

    private Integer szie;

    private String sziestring;

    private Integer number;

    public Integer getShoppingcarid() {
        return shoppingcarid;
    }

    public void setShoppingcarid(Integer shoppingcarid) {
        this.shoppingcarid = shoppingcarid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getTaste() {
        return taste;
    }

    public void setTaste(Integer taste) {
        this.taste = taste;
    }

    public Integer getColour() {
        return colour;
    }

    public void setColour(Integer colour) {
        this.colour = colour;
    }

    public Integer getSzie() {
        return szie;
    }

    public void setSzie(Integer szie) {
        this.szie = szie;
    }

    public String getSziestring() {
        return sziestring;
    }

    public void setSziestring(String sziestring) {
        this.sziestring = sziestring == null ? null : sziestring.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}