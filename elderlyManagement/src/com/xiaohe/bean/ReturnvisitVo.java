package com.xiaohe.bean;

import java.util.List;

public class ReturnvisitVo {

	private Integer pageSum;//总页数
	private Integer recordSum;
	private List<ReturnvisitCustom> returnvisitList;
	public Integer getPageSum() {
		return pageSum;
	}
	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}
	public Integer getRecordSum() {
		return recordSum;
	}
	public void setRecordSum(Integer recordSum) {
		this.recordSum = recordSum;
	}
	public List<ReturnvisitCustom> getReturnvisitList() {
		return returnvisitList;
	}
	public void setReturnvisitList(List<ReturnvisitCustom> returnvisitList) {
		this.returnvisitList = returnvisitList;
	}
	
}
