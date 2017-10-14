package com.xiaohe.bean;

import java.math.BigDecimal;

public class Shoppingcar {
    private Integer shoppingcarid;

    private Integer userid;

    private Integer productid;

    private String productname;

    private BigDecimal price;

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
}