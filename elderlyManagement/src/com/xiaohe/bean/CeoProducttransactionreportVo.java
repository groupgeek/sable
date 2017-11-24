package com.xiaohe.bean;

import java.util.List;

public class CeoProducttransactionreportVo {
	private Integer pageSum;//总页数
	private Integer productSum;//总条数
	private List<CeoProducttransactionreport> lisproductchart;
	public Integer getPageSum() {
		return pageSum;
	}
	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}
	public Integer getProductSum() {
		return productSum;
	}
	public void setProductSum(Integer productSum) {
		this.productSum = productSum;
	}
	public List<CeoProducttransactionreport> getLisproductchart() {
		return lisproductchart;
	}
	public void setLisproductchart(List<CeoProducttransactionreport> lisproductchart) {
		this.lisproductchart = lisproductchart;
	}
	
}
