package com.xiaohe.bean;

import java.math.BigDecimal;

public class Product {
    private Integer productid;

    private String productname;

    private Integer instock;

    private BigDecimal price;

    private String picture;

    private Boolean shelves;

    private Integer buyno;

    private BigDecimal purchaseprice;

    private Integer producttypeid;

    private Integer branchid;

    private Boolean discount;

    private Integer good;

    private String description;

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

    public Integer getInstock() {
        return instock;
    }

    public void setInstock(Integer instock) {
        this.instock = instock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Boolean getShelves() {
        return shelves;
    }

    public void setShelves(Boolean shelves) {
        this.shelves = shelves;
    }

    public Integer getBuyno() {
        return buyno;
    }

    public void setBuyno(Integer buyno) {
        this.buyno = buyno;
    }

    public BigDecimal getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(BigDecimal purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public Integer getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(Integer producttypeid) {
        this.producttypeid = producttypeid;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public Boolean getDiscount() {
        return discount;
    }

    public void setDiscount(Boolean discount) {
        this.discount = discount;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname="
				+ productname + ", instock=" + instock + ", price=" + price
				+ ", picture=" + picture + ", shelves=" + shelves + ", buyno="
				+ buyno + ", purchaseprice=" + purchaseprice
				+ ", producttypeid=" + producttypeid + ", branchid=" + branchid
				+ ", discount=" + discount + ", good=" + good
				+ ", description=" + description + "]";
	}
}