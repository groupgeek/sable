package com.xiaohe.bean;

import java.math.BigDecimal;

public class Level {
    private Integer levelid;

    private BigDecimal minmoney;

    private BigDecimal maxmoney;

    private String level;

    public Integer getLevelid() {
        return levelid;
    }

    public void setLevelid(Integer levelid) {
        this.levelid = levelid;
    }

    public BigDecimal getMinmoney() {
        return minmoney;
    }

    public void setMinmoney(BigDecimal minmoney) {
        this.minmoney = minmoney;
    }

    public BigDecimal getMaxmoney() {
        return maxmoney;
    }

    public void setMaxmoney(BigDecimal maxmoney) {
        this.maxmoney = maxmoney;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level == null ? null : level.trim();
    }
}