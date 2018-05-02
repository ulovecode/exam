package com.ulovecode.modules.exception;

import com.ulovecode.modules.enums.ResultEnum;


public class CourseException extends RuntimeException{

    private Integer code;

    public CourseException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public CourseException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
