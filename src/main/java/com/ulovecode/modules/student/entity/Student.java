package com.ulovecode.modules.student.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@Accessors(chain = true)
@Data
@ApiModel("学生信息")
public class Student implements Serializable {
    @ApiModelProperty(value = "学号",example = "1111",position = 1)
    private String sno;
    @ApiModelProperty(value = "身份证id",example = "422201199512137915",position = 2)
    private String idno;
    @ApiModelProperty(value = "密码",example = "1111",position = 3)
    private String passwd;
    @ApiModelProperty(value = "主修",example = "计算及科学与技术",position = 4)
    private String major;
    @ApiModelProperty(value = "班级号",example = "20154101",position = 5)
    private String classno;
    @ApiModelProperty(value = "姓名",example = "朱博文",position = 6)
    private String sname;
    @ApiModelProperty(value = "拼音名",example = "zhubowen",position = 7)
    private String pyname;
    @ApiModelProperty(value = "性别",example = "男",position = 8)
    private String gender;
    @ApiModelProperty(value = "生日",example = "1995-12-13",position = 9)
    private String birthday;
    @ApiModelProperty(value = "图片地址",example = "http://localhost:8080/student/img/1234.jpg",position = 10)
    private String pic;
    @ApiModelProperty(value = "高中学校",example = "武汉市第一初级中学",position = 11)
    private String highSchool;
    @ApiModelProperty(value = "高考分数",example = "111",position = 12)
    private Integer highScore;
    @ApiModelProperty(value = "招生来源",example = "统招",position = 13)
    private String insource;
    @ApiModelProperty(value = "招生类型",example = "大专",position = 14)
    private String intype;
    @ApiModelProperty(value = "国籍",example = "中国",position = 15)
    private String nation;
    @ApiModelProperty(value = "政治状态",example = "群众",position = 16)
    private String politicalStatus;
    @ApiModelProperty(value = "电话号码",example = "17683709258",position = 17)
    private String tel;

    @ApiModelProperty(value = "qq",example = "435999799",position = 18)
    private String qq;
    @ApiModelProperty(value = "邮箱",example = "435999799@qq.com",position = 19)
    private String email;

    @ApiModelProperty(value = "学生描述",example = "成绩优异xxx",position = 20)
    private String descript;

    @ApiModelProperty(value = "记录时间",position = 21)
    private Date recDtime;


}