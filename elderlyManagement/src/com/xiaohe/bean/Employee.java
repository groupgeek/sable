package com.xiaohe.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Employee {
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

    private String employeestatus;

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
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAccountnumber() {
        return accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber == null ? null : accountnumber.trim();
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename == null ? null : employeename.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
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
        this.phone = phone == null ? null : phone.trim();
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
        this.address = address == null ? null : address.trim();
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
        this.bankcardno = bankcardno == null ? null : bankcardno.trim();
    }

    public BigDecimal getTotalbonus() {
        return totalbonus;
    }

    public void setTotalbonus(BigDecimal totalbonus) {
        this.totalbonus = totalbonus;
    }

    public String getEmployeestatus() {
        return employeestatus;
    }

    public void setEmployeestatus(String employeestatus) {
        this.employeestatus = employeestatus == null ? null : employeestatus.trim();
    }
}