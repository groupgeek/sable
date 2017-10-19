package com.xiaohe.bean;

public class Producttype {
    private Integer producttypeid;

    private String producttypename;

    private Integer fatherid;

    public Integer getProducttypeid() {
        return producttypeid;
    }

    public void setProducttypeid(Integer producttypeid) {
        this.producttypeid = producttypeid;
    }

    public String getProducttypename() {
        return producttypename;
    }

    public void setProducttypename(String producttypename) {
        this.producttypename = producttypename == null ? null : producttypename.trim();
    }

    public Integer getFatherid() {
        return fatherid;
    }

    public void setFatherid(Integer fatherid) {
        this.fatherid = fatherid;
    }

	@Override
	public String toString() {
		return "Producttype [producttypeid=" + producttypeid
				+ ", producttypename=" + producttypename + ", fatherid="
				+ fatherid + "]";
	}
}