package com.ulovecode.modules.student.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@Accessors(chain = true)
@Data
public class Student implements Serializable {
    private String sno;

    private String idno;

    private String passwd;

    private String major;

    private String classno;

    private String sname;

    private String pyname;

    private String gender;

    private String birthday;

    private String pic;

    private String highSchool;

    private Integer highScore;

    private String insource;

    private String intype;

    private String nation;

    private String politicalStatus;

    private String tel;

    private String qq;

    private String email;

    private String descript;

    private Date recDtime;


}