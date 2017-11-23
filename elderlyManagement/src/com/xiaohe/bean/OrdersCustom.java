package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Date;

public class OrdersCustom extends Orders {
	private ProductCustom productInfo;
	private ProducttasteCustom producttasteInfo;
	private ProductcolourCustom productcolourInfo;
	private Integer type;//商品分类
	
	private String[] ordersid;//订单id数组
	
	private String paymentMethod;//支付方式
	
	
	
	
	private String paymenttimeString;

    private String timeofarrivalString;

    private String submissiontimeString;
    
    private String ordertimeString;
    
	
    private String picture;
	private String description;
	
	private Date start;
	private Date end;
	
	private BigDecimal totalexl;     //总支出
	private BigDecimal totalIncome;  //总收入
	
	private String stringDate;
	private String sumorderIncome;
	
	public String getStringDate() {
		return stringDate;
	}
	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}
	public String getSumorderIncome() {
		return sumorderIncome;
	}
	public void setSumorderIncome(String sumorderIncome) {
		this.sumorderIncome = sumorderIncome;
	}
	public BigDecimal getTotalexl() {
		return totalexl;
	}
	public void setTotalexl(BigDecimal totalexl) {
		this.totalexl = totalexl;
	}
	public BigDecimal getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(BigDecimal totalIncome) {
		this.totalIncome = totalIncome;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
	public BigDecimal[] getIncomeReport() {
		return incomeReport;
	}
	public void setIncomeReport(BigDecimal[] incomeReport) {
		this.incomeReport = incomeReport;
	}
	public Integer getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}
	private BigDecimal[] incomeReport; 
	private Integer employeeid;
	
	
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String[] getOrdersid() {
		return ordersid;
	}
	public void setOrdersid(String[] ordersid) {
		this.ordersid = ordersid;
	}
	public String getPaymenttimeString() {
		return paymenttimeString;
	}
	public void setPaymenttimeString(String paymenttimeString) {
		this.paymenttimeString = paymenttimeString;
	}
	public String getTimeofarrivalString() {
		return timeofarrivalString;
	}
	public void setTimeofarrivalString(String timeofarrivalString) {
		this.timeofarrivalString = timeofarrivalString;
	}
	public String getSubmissiontimeString() {
		return submissiontimeString;
	}
	public void setSubmissiontimeString(String submissiontimeString) {
		this.submissiontimeString = submissiontimeString;
	}
	public String getOrdertimeString() {
		return ordertimeString;
	}
	public void setOrdertimeString(String ordertimeString) {
		this.ordertimeString = ordertimeString;
	}
	
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ProductCustom getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(ProductCustom productInfo) {
		this.productInfo = productInfo;
	}
	public ProducttasteCustom getProducttasteInfo() {
		return producttasteInfo;
	}
	public void setProducttasteInfo(ProducttasteCustom producttasteInfo) {
		this.producttasteInfo = producttasteInfo;
	}
	public ProductcolourCustom getProductcolourInfo() {
		return productcolourInfo;
	}
	public void setProductcolourInfo(ProductcolourCustom productcolourInfo) {
		this.productcolourInfo = productcolourInfo;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	

}
