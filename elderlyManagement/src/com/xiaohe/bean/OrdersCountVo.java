package com.xiaohe.bean;

public class OrdersCountVo {
	private Integer pendingPayment;
	private Integer tobeDelivered;
	private Integer tobeReceived;
	private Integer beEvaluated;
	public Integer getPendingPayment() {
		return pendingPayment;
	}
	public void setPendingPayment(Integer pendingPayment) {
		this.pendingPayment = pendingPayment;
	}
	public Integer getTobeDelivered() {
		return tobeDelivered;
	}
	public void setTobeDelivered(Integer tobeDelivered) {
		this.tobeDelivered = tobeDelivered;
	}
	public Integer getTobeReceived() {
		return tobeReceived;
	}
	public void setTobeReceived(Integer tobeReceived) {
		this.tobeReceived = tobeReceived;
	}
	public Integer getBeEvaluated() {
		return beEvaluated;
	}
	public void setBeEvaluated(Integer beEvaluated) {
		this.beEvaluated = beEvaluated;
	}

}
