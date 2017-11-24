package com.xiaohe.bean;

import java.math.BigDecimal;

public class EvaluationCustom extends Evaluation {
	private String praiseOf;
	private Integer praise;
	private Integer average;
	private Integer badReview;
	
	private String username;
	private String avatar;
	
	private Integer evaluationLevalSum;
	
	private String stringDate;
	
	private Integer begin;
	private Integer pageNum;
	private Integer currentPage;
	
	
	private String productname;
	private String description;
	private String productpicture;
	private BigDecimal price;
	
	
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getProductpicture() {
		return productpicture;
	}
	public void setProductpicture(String productpicture) {
		this.productpicture = productpicture;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getBegin() {
		return begin;
	}
	public void setBegin(Integer begin) {
		this.begin = begin;
	}
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	public String getStringDate() {
		return stringDate;
	}
	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Integer getPraise() {
		return praise;
	}
	public void setPraise(Integer praise) {
		this.praise = praise;
	}
	public Integer getAverage() {
		return average;
	}
	public void setAverage(Integer average) {
		this.average = average;
	}
	public Integer getBadReview() {
		return badReview;
	}
	public void setBadReview(Integer badReview) {
		this.badReview = badReview;
	}
	public String getPraiseOf() {
		return praiseOf;
	}
	public void setPraiseOf(String praiseOf) {
		this.praiseOf = praiseOf;
	}
	public Integer getEvaluationLevalSum() {
		return evaluationLevalSum;
	}
	public void setEvaluationLevalSum(Integer evaluationLevalSum) {
		this.evaluationLevalSum = evaluationLevalSum;
	}
	

}
