package com.xiaohe.bean;

public class Productcolour {
    private Integer productcolourid;

    private Integer productid;

    private String productcolour;

    public Integer getProductcolourid() {
        return productcolourid;
    }

    public void setProductcolourid(Integer productcolourid) {
        this.productcolourid = productcolourid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductcolour() {
        return productcolour;
    }

    public void setProductcolour(String productcolour) {
        this.productcolour = productcolour == null ? null : productcolour.trim();
    }
}