package com.xiaohe.bean;

import java.util.List;

public class TransactionVo {
	private Integer pageSum;//总页数
	private Integer recordSum;//总条数
	private List<TransactionCustom> transactionList;
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
	public List<TransactionCustom> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<TransactionCustom> transactionList) {
		this.transactionList = transactionList;
	}
	
}
