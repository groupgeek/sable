package com.xiaohe.bean;

import java.util.List;

public class MessageVo {
	private Message message;
	private int start;
	private int size;
	private int count;
	private Integer employeeid;
	
	private Integer pageSum;//总页数
	private Integer messageSum;
	private List<MessageCustom> allMessage;
	
	
	public Integer getPageSum() {
		return pageSum;
	}
	public void setPageSum(Integer pageSum) {
		this.pageSum = pageSum;
	}
	public Integer getMessageSum() {
		return messageSum;
	}
	public void setMessageSum(Integer messageSum) {
		this.messageSum = messageSum;
	}
	public List<MessageCustom> getAllMessage() {
		return allMessage;
	}
	public void setAllMessage(List<MessageCustom> allMessage) {
		this.allMessage = allMessage;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	private Integer nowPage;
	public Integer getNowPage() {
		return nowPage;
	}
	public void setNowPage(Integer nowPage) {
		this.nowPage = nowPage;
	}
	public Message getMessage() {
		return message;
	}
	public void setMessage(Message message) {
		this.message = message;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
