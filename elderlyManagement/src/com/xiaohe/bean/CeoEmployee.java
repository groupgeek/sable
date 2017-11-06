package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CeoEmployee extends Employee{
	
	private Integer employeeid;

    private String avatar;

    private String password;

    private String email;

    private String accountnumber;

    private String employeename;

    private String sex;

    private Date birthday;

    private String phone;

    private Integer areaid;

    private Integer authorityid;

    private String address;

    private BigDecimal wage;

    private Date entrytime;

    private Integer positionid;

    private String bankcardno;

    private BigDecimal totalbonus;
    
    private String authoritylevel;
    
    private String positionname;
    
    private Integer branchid;

	private String branchname;
	
	private String stringUserDate;
	
	private String stringemloyeeDate;

	public Integer getBranchid() {
		return branchid;
	}

	public void setBranchid(Integer branchid) {
		this.branchid = branchid;
	}
	
	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getEmployeename() {
		return employeename;
	}

	public void setEmployeename(String employeename) {
		this.employeename = employeename;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getAreaid() {
		return areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public Integer getAuthorityid() {
		return authorityid;
	}

	public void setAuthorityid(Integer authorityid) {
		this.authorityid = authorityid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getWage() {
		return wage;
	}

	public void setWage(BigDecimal wage) {
		this.wage = wage;
	}

	public Date getEntrytime() {
		return entrytime;
	}

	public void setEntrytime(Date entrytime) {
		this.entrytime = entrytime;
	}

	public Integer getPositionid() {
		return positionid;
	}

	public void setPositionid(Integer positionid) {
		this.positionid = positionid;
	}

	public String getBankcardno() {
		return bankcardno;
	}

	public void setBankcardno(String bankcardno) {
		this.bankcardno = bankcardno;
	}

	public BigDecimal getTotalbonus() {
		return totalbonus;
	}

	public void setTotalbonus(BigDecimal totalbonus) {
		this.totalbonus = totalbonus;
	}

	public String getAuthoritylevel() {
		return authoritylevel;
	}

	public void setAuthoritylevel(String authoritylevel) {
		this.authoritylevel = authoritylevel;
	}

	public String getPositionname() {
		return positionname;
	}

	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}

	public String getBranchname() {
		return branchname;
	}

	public void setBranchname(String branchname) {
		this.branchname = branchname;
	}

	public String getStringUserDate() {
		return stringUserDate;
	}

	public void setStringUserDate(String stringUserDate) {
		this.stringUserDate = stringUserDate;
	}

	public String getStringemloyeeDate() {
		return stringemloyeeDate;
	}

	public void setStringemloyeeDate(String stringemloyeeDate) {
		this.stringemloyeeDate = stringemloyeeDate;
	}

	@Override
	public String toString() {
		return "CeoEmployee [employeeid=" + employeeid + ", avatar=" + avatar
				+ ", password=" + password + ", email=" + email
				+ ", accountnumber=" + accountnumber + ", employeename="
				+ employeename + ", sex=" + sex + ", birthday=" + birthday
				+ ", phone=" + phone + ", areaid=" + areaid + ", authorityid="
				+ authorityid + ", address=" + address + ", wage=" + wage
				+ ", entrytime=" + entrytime + ", positionid=" + positionid
				+ ", bankcardno=" + bankcardno + ", totalbonus=" + totalbonus
				+ ", authoritylevel=" + authoritylevel + ", positionname="
				+ positionname + ", branchid=" + branchid + ", branchname="
				+ branchname + "]";
	}

	
}
