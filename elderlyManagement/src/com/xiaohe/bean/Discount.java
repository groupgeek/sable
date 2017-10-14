package com.xiaohe.bean;

import java.math.BigDecimal;

public class Discount {
    private Integer discountid;

    private Integer productid;

    private BigDecimal discount;

    private String discountreason;

    public Integer getDiscountid() {
        return discountid;
    }

    public void setDiscountid(Integer discountid) {
        this.discountid = discountid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDiscountreason() {
        return discountreason;
    }

    public void setDiscountreason(String discountreason) {
        this.discountreason = discountreason == null ? null : discountreason.trim();
    }
}