package com.xiaohe.bean;

import java.math.BigDecimal;

public class CeoProducttransactionreport extends Producttransactionreport{
	
	private BigDecimal getprice;
	private BigDecimal toprice;
	private String stringTime;
	private String summoney;

	public String getSummoney() {
		return summoney;
	}

	public void setSummoney(String summoney) {
		this.summoney = summoney;
	}

	public String getStringTime() {
		return stringTime;
	}

	public void setStringTime(String stringTime) {
		this.stringTime = stringTime;
	}

	public BigDecimal getGetprice() {
		return getprice;
	}

	public void setGetprice(BigDecimal getprice) {
		this.getprice = getprice;
	}

	public BigDecimal getToprice() {
		return toprice;
	}

	public void setToprice(BigDecimal toprice) {
		this.toprice = toprice;
	}

}
