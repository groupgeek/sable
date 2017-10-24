package com.xiaohe.bean;

public class Productcoloursize {
    private Integer sizeid;

    private Integer productcolourid;

    private String size;

    private Integer sizestock;

    public Integer getSizeid() {
        return sizeid;
    }

    public void setSizeid(Integer sizeid) {
        this.sizeid = sizeid;
    }

    public Integer getProductcolourid() {
        return productcolourid;
    }

    public void setProductcolourid(Integer productcolourid) {
        this.productcolourid = productcolourid;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Integer getSizestock() {
        return sizestock;
    }

    public void setSizestock(Integer sizestock) {
        this.sizestock = sizestock;
    }
}