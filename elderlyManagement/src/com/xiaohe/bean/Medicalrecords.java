package com.xiaohe.bean;

import java.util.Date;

public class Medicalrecords {
    private Integer medicalrecordsid;

    private Integer userid;

    private String username;

    private String sex;

    private Date birthday;

    public Integer getMedicalrecordsid() {
        return medicalrecordsid;
    }

    public void setMedicalrecordsid(Integer medicalrecordsid) {
        this.medicalrecordsid = medicalrecordsid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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
}