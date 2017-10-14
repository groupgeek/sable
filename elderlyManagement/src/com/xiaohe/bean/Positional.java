package com.xiaohe.bean;

import java.math.BigDecimal;

public class Positional {
    private Integer positionid;

    private BigDecimal minwage;

    private BigDecimal maxwage;

    private String positionname;

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public BigDecimal getMinwage() {
        return minwage;
    }

    public void setMinwage(BigDecimal minwage) {
        this.minwage = minwage;
    }

    public BigDecimal getMaxwage() {
        return maxwage;
    }

    public void setMaxwage(BigDecimal maxwage) {
        this.maxwage = maxwage;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname == null ? null : positionname.trim();
    }
}