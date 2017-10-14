package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Totalreport {
    private Integer id;

    private BigDecimal totalprice;

    private BigDecimal totalexpenditure;

    private Integer branchid;

    private Date duringtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDuringtime() {
        return duringtime;
    }

    public void setDuringtime(Date duringtime) {
        this.duringtime = duringtime;
    }
}