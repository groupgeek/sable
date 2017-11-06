package com.xiaohe.bean;

import java.math.BigDecimal;

import com.sun.istack.internal.NotNull;


public class Product {
    private Integer productid;
    
@NotNull
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

    private String origin;

    private Double productspecifications;

    private Integer shelflife;

    private String producstandards;

    private String productionlicensenumber;

    private String storagemethod;

    private String ediblemethod;

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

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin == null ? null : origin.trim();
    }

    public Double getProductspecifications() {
        return productspecifications;
    }

    public void setProductspecifications(Double productspecifications) {
        this.productspecifications = productspecifications;
    }

    public Integer getShelflife() {
        return shelflife;
    }

    public void setShelflife(Integer shelflife) {
        this.shelflife = shelflife;
    }

    public String getProducstandards() {
        return producstandards;
    }

    public void setProducstandards(String producstandards) {
        this.producstandards = producstandards == null ? null : producstandards.trim();
    }

    public String getProductionlicensenumber() {
        return productionlicensenumber;
    }

    public void setProductionlicensenumber(String productionlicensenumber) {
        this.productionlicensenumber = productionlicensenumber == null ? null : productionlicensenumber.trim();
    }

    public String getStoragemethod() {
        return storagemethod;
    }

    public void setStoragemethod(String storagemethod) {
        this.storagemethod = storagemethod == null ? null : storagemethod.trim();
    }

    public String getEdiblemethod() {
        return ediblemethod;
    }

    public void setEdiblemethod(String ediblemethod) {
        this.ediblemethod = ediblemethod == null ? null : ediblemethod.trim();
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
				+ ", discount=" + discount + ", good=" + good + ", origin="
				+ origin + ", productspecifications=" + productspecifications
				+ ", shelflife=" + shelflife + ", producstandards="
				+ producstandards + ", productionlicensenumber="
				+ productionlicensenumber + ", storagemethod=" + storagemethod
				+ ", ediblemethod=" + ediblemethod + ", description="
				+ description + "]";
	}
}