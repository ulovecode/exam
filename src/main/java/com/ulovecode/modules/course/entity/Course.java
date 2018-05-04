package com.ulovecode.modules.course.entity;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class Course implements Serializable {
    private Integer courseId;

    private String cname;

    private String ctype;

    private Integer credit;

    private Integer times;

    private String stage;

    private String descript;

    public Course() {
    }

    public Course(Integer courseId, String cname, String ctype, Integer credit, Integer times, String stage, String descript) {
        this.courseId = courseId;
        this.cname = cname;
        this.ctype = ctype;
        this.credit = credit;
        this.times = times;
        this.stage = stage;
        this.descript = descript;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype == null ? null : ctype.trim();
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage == null ? null : stage.trim();
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript == null ? null : descript.trim();
    }
}