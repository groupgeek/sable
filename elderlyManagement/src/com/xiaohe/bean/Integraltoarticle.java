package com.xiaohe.bean;

import java.math.BigDecimal;

public class Integraltoarticle {
    private Integer articleid;

    private String articlename;

    private BigDecimal purchaseprice;

    private Integer integral;

    private Integer instock;

    private String picture;

    private Integer branchid;

    private String detail;

    public Integer getArticleid() {
        return articleid;
    }

    public void setArticleid(Integer articleid) {
        this.articleid = articleid;
    }

    public String getArticlename() {
        return articlename;
    }

    public void setArticlename(String articlename) {
        this.articlename = articlename == null ? null : articlename.trim();
    }

    public BigDecimal getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(BigDecimal purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public Integer getInstock() {
        return instock;
    }

    public void setInstock(Integer instock) {
        this.instock = instock;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

	@Override
	public String toString() {
		return "Integraltoarticle [articleid=" + articleid + ", articlename="
				+ articlename + ", purchaseprice=" + purchaseprice
				+ ", integral=" + integral + ", instock=" + instock
				+ ", picture=" + picture + ", branchid=" + branchid
				+ ", detail=" + detail + ", getArticleid()=" + getArticleid()
				+ ", getArticlename()=" + getArticlename()
				+ ", getPurchaseprice()=" + getPurchaseprice()
				+ ", getIntegral()=" + getIntegral() + ", getInstock()="
				+ getInstock() + ", getPicture()=" + getPicture()
				+ ", getBranchid()=" + getBranchid() + ", getDetail()="
				+ getDetail() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
    
}