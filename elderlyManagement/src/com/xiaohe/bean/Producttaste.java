package com.xiaohe.bean;

public class Producttaste {
    private Integer producttasteid;

    private Integer productid;

    private String producttaste;

    private Integer tastestock;

    public Integer getProducttasteid() {
        return producttasteid;
    }

    public void setProducttasteid(Integer producttasteid) {
        this.producttasteid = producttasteid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProducttaste() {
        return producttaste;
    }

    public void setProducttaste(String producttaste) {
        this.producttaste = producttaste == null ? null : producttaste.trim();
    }

    public Integer getTastestock() {
        return tastestock;
    }

    public void setTastestock(Integer tastestock) {
        this.tastestock = tastestock;
    }
}