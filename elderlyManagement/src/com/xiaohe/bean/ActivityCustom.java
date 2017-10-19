package com.xiaohe.bean;

public class ActivityCustom extends Activity {

	/**
	 * 扩展类
	 * begin total ：：sql limit begin, total
	 * introduction 简介
	 */
	private Integer begin;
	private Integer total;
	private String introduction;
	private String websitetype;
	private Integer countUsers;
	
	public Integer getCountUsers() {
		return countUsers;
	}
	public void setCountUsers(Integer countUsers) {
		this.countUsers = countUsers;
	}
	public String getWebsitetype() {
		return websitetype;
	}
	public void setWebsitetype(String websitetype) {
		this.websitetype = websitetype;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
