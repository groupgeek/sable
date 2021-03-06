package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Producttransactionreport {
    private Integer transactionid;

    private Integer userid;

    private Integer productid;

    private Integer countbuy;

    private Date buytime;

    private BigDecimal totalprice;

    private BigDecimal totalexpenditure;

    private Integer branchid;

    public Integer getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(Integer transactionid) {
        this.transactionid = transactionid;
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

    public Integer getCountbuy() {
        return countbuy;
    }

    public void setCountbuy(Integer countbuy) {
        this.countbuy = countbuy;
    }

    public Date getBuytime() {
        return buytime;
    }

    public void setBuytime(Date buytime) {
        this.buytime = buytime;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public BigDecimal getTotalexpenditure() {
        return totalexpenditure;
    }

    public void setTotalexpenditure(BigDecimal totalexpenditure) {
        this.totalexpenditure = totalexpenditure;
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }
}