package com.xiaohe.bean;

public class Productrecommend {
    private Integer productrecommendid;

    private Integer productid;

    private Integer branchid;

    private String type;

    private Boolean productshow;

    public Integer getProductrecommendid() {
        return productrecommendid;
    }

    public void setProductrecommendid(Integer productrecommendid) {
        this.productrecommendid = productrecommendid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Boolean getProductshow() {
        return productshow;
    }

    public void setProductshow(Boolean productshow) {
        this.productshow = productshow;
    }
}