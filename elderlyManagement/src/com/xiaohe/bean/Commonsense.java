package com.xiaohe.bean;

import java.util.Date;

public class Commonsense {
    private Integer commonsenseid;

    private Integer editorid;

    private String websitetype;

	private String contexttype;

    private Integer branchid;

    private String title;

    private String picture;

    private Date createtime;

    private String context;

    public Integer getCommonsenseid() {
        return commonsenseid;
    }

    public void setCommonsenseid(Integer commonsenseid) {
        this.commonsenseid = commonsenseid;
    }

    public Integer getEditorid() {
        return editorid;
    }

    public void setEditorid(Integer editorid) {
        this.editorid = editorid;
    }

    public String getWebsitetype() {
        return websitetype;
    }

    public void setWebsitetype(String websitetype) {
        this.websitetype = websitetype == null ? null : websitetype.trim();
    }

    public String getContexttype() {
        return contexttype;
    }

    public void setContexttype(String contexttype) {
        this.contexttype = contexttype == null ? null : contexttype.trim();
    }

    public Integer getBranchid() {
        return branchid;
    }

    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
    @Override
	public String toString() {
		return "Commonsense [commonsenseid=" + commonsenseid + ", editorid="
				+ editorid + ", websitetype=" + websitetype + ", contexttype="
				+ contexttype + ", branchid=" + branchid + ", title=" + title
				+ ", picture=" + picture + ", createtime=" + createtime
				+ ", context=" + context + "]";
	}

}