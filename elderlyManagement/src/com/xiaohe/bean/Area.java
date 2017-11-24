package com.xiaohe.bean;

public class Area {
    private Integer areaid;

    private String areaname;

    private String areaaddress;

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    public String getAreaaddress() {
        return areaaddress;
    }

    public void setAreaaddress(String areaaddress) {
        this.areaaddress = areaaddress == null ? null : areaaddress.trim();
    }
}