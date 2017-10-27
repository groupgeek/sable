package com.xiaohe.bean;

public class Evaluation {
    private Integer evaluationid;

    private Integer userid;

    private Integer productid;

    private Integer evaluationleval;

    private String picture;

    private String video;

    private String evaluationcontent;

    public Integer getEvaluationid() {
        return evaluationid;
    }

    public void setEvaluationid(Integer evaluationid) {
        this.evaluationid = evaluationid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getEvaluationleval() {
        return evaluationleval;
    }

    public void setEvaluationleval(Integer evaluationleval) {
        this.evaluationleval = evaluationleval;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public String getEvaluationcontent() {
        return evaluationcontent;
    }

    public void setEvaluationcontent(String evaluationcontent) {
        this.evaluationcontent = evaluationcontent == null ? null : evaluationcontent.trim();
    }
}