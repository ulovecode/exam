package com.ulovecode.modules.course.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
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

}