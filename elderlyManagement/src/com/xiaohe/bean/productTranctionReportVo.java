package com.xiaohe.bean;

import java.util.List;

public class productTranctionReportVo {
	private Integer pageSum;//总页数
	private Integer Sum;
	private List<ProducttransactionreportCustom> List;
	public Integer getPageSum() {
		return pageSum;
	}
	public List<ProducttransactionreportCustom> getList() {
		return List;
	}
	public void setList(List<ProducttransactionreportCustom> list) {
		List = list;
	}
	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}
	
	public Integer getSum() {
		return Sum;
	}
	public void setSum(Integer sum) {
		Sum = sum;
	}
	
	
}
