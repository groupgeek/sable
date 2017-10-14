package com.xiaohe.bean;

import java.util.Date;

public class Message {
    private Integer messageid;

    private Integer userid;

    private Date messagetime;

    private String messagecontext;

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getMessagetime() {
        return messagetime;
    }

    public void setMessagetime(Date messagetime) {
        this.messagetime = messagetime;
    }

    public String getMessagecontext() {
        return messagecontext;
    }

    public void setMessagecontext(String messagecontext) {
        this.messagecontext = messagecontext == null ? null : messagecontext.trim();
    }
}