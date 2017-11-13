package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CeoActivity extends Activity{
	
	private Integer activityid;

    private String activityname;

    private Integer activitytypeid;

    private Boolean online;

    private String activitypicture;

    private String activitystatus;

    private Date activitydate;

    private Integer branchid;

    private BigDecimal registeryfee;

    private String video;

    private BigDecimal activityprice;

    private String activitydetails;
    
    private String activitytypename;
    
    private String branchname;
    
    private String registery;
    
    private String stringDate;
    
    private String stringTime;
    
    private String stringline;
    
    private String sumactivityPrice;
    
    private String sumregisteryFee;

	public String getStringTime() {
		return stringTime;
	}

	public void setStringTime(String stringTime) {
		this.stringTime = stringTime;
	}

	public String getSumactivityPrice() {
		return sumactivityPrice;
	}

	public void setSumactivityPrice(String sumactivityPrice) {
		this.sumactivityPrice = sumactivityPrice;
	}

	public String getSumregisteryFee() {
		return sumregisteryFee;
	}

	public void setSumregisteryFee(String sumregisteryFee) {
		this.sumregisteryFee = sumregisteryFee;
	}

	public String getRegistery() {
		return registery;
	}

	public void setRegistery(String registery) {
		this.registery = registery;
	}

	public Integer getActivityid() {
		return activityid;
	}

	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}

	public String getActivityname() {
		return activityname;
	}

	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}

	public Integer getActivitytypeid() {
		return activitytypeid;
	}

	public void setActivitytypeid(Integer activitytypeid) {
		this.activitytypeid = activitytypeid;
	}

	public Boolean getOnline() {
		return online;
	}

	public void setOnline(Boolean online) {
		this.online = online;
	}

	public String getActivitypicture() {
		return activitypicture;
	}

	public void setActivitypicture(String activitypicture) {
		this.activitypicture = activitypicture;
	}

	public String getActivitystatus() {
		return activitystatus;
	}

	public void setActivitystatus(String activitystatus) {
		this.activitystatus = activitystatus;
	}

	public Date getActivitydate() {
		return activitydate;
	}

	public void setActivitydate(Date activitydate) {
		this.activitydate = activitydate;
	}

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}

	public BigDecimal getRegisteryfee() {
		return registeryfee;
	}

	public void setRegisteryfee(BigDecimal registeryfee) {
		this.registeryfee = registeryfee;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public BigDecimal getActivityprice() {
		return activityprice;
	}

	public void setActivityprice(BigDecimal activityprice) {
		this.activityprice = activityprice;
	}

	public String getActivitydetails() {
		return activitydetails;
	}

	public void setActivitydetails(String activitydetails) {
		this.activitydetails = activitydetails;
	}

	public String getActivitytypename() {
		return activitytypename;
	}

	public void setActivitytypename(String activitytypename) {
		this.activitytypename = activitytypename;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getStringDate() {
		return stringDate;
	}

	public void setStringDate(String stringDate) {
		this.stringDate = stringDate;
	}

	public String getStringline() {
		return stringline;
	}

	public void setStringline(String stringline) {
		this.stringline = stringline;
	}

	@Override
	public String toString() {
		return "CeoActivity [activityid=" + activityid + ", activityname="
				+ activityname + ", activitytypeid=" + activitytypeid
				+ ", online=" + online + ", activitypicture=" + activitypicture
				+ ", activitystatus=" + activitystatus + ", activitydate="
				+ activitydate + ", branchid=" + branchid + ", registeryfee="
				+ registeryfee + ", video=" + video + ", activityprice="
				+ activityprice + ", activitydetails=" + activitydetails
				+ ", activitytypename=" + activitytypename + ", branchname="
				+ branchname + ", registery=" + registery + "]";
	}

}
