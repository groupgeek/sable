package com.xiaohe.bean;

public class Lecturer {
    private Integer lecturerid;

    private String name;

    private String work;

    private Integer attention;

    private Integer like;

    private String avater;

    public Integer getLecturerid() {
        return lecturerid;
    }

    public void setLecturerid(Integer lecturerid) {
        this.lecturerid = lecturerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work == null ? null : work.trim();
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public String getAvater() {
        return avater;
    }

    public void setAvater(String avater) {
        this.avater = avater == null ? null : avater.trim();
    }
}