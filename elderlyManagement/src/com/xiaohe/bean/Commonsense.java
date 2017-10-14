package com.xiaohe.bean;

public class Commonsense {
    private Integer editorid;

    private String websitetype;

    private String contexttype;

    private Integer branchid;

    private String title;

    private String picture;

    private Boolean yshow;

    private String context;

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

    public Boolean getYshow() {
        return yshow;
    }

    public void setYshow(Boolean yshow) {
        this.yshow = yshow;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
}