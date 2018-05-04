package com.ulovecode.common.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {

    SUCCESS(0, "成功"),

    PARAM_ERROR(1, "参数不正确"),

    COURSE_NOT_FOUND(2, "没有该课程"),

    ITEM_NOT_FOUND(11, "没有找到改项目"),

    LOGIN_FAIL(25, "登录失败, 登录信息不正确"),

    LOGOUT_SUCCESS(26, "登出成功"),
    MUST_HAVE_A_COURSE(31, "必须有一门课程被创建"),


    STUDENT_ID_OR_IDNO_IS_CONFILICT(31, "学号或者身份证号已经存在");


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    }
