package com.xiaohe.bean;

import java.math.BigDecimal;

public class Transaction {
    private Integer transactionid;

    private Integer userid;

    private Float cycle;

    private Float frequency;

    private BigDecimal totalprice;

    private Integer countbuy;

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

    public Float getCycle() {
        return cycle;
    }

    public void setCycle(Float cycle) {
        this.cycle = cycle;
    }

    public Float getFrequency() {
        return frequency;
    }

    public void setFrequency(Float frequency) {
        this.frequency = frequency;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getCountbuy() {
        return countbuy;
    }

    public void setCountbuy(Integer countbuy) {
        this.countbuy = countbuy;
    }
}