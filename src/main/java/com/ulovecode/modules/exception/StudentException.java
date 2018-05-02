package com.ulovecode.modules.exception;

import com.ulovecode.modules.enums.ResultEnum;


public class StudentException extends RuntimeException{

    private Integer code;

    public StudentException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public StudentException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
