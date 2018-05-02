package com.ulovecode.modules.exception;

import com.ulovecode.modules.enums.ResultEnum;


public class UserInfoException extends RuntimeException{

    private Integer code;

    public UserInfoException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public UserInfoException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
