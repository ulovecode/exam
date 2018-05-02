package com.ulovecode.modules.exception;

import com.ulovecode.modules.enums.ResultEnum;


public class PaperException extends RuntimeException{

    private Integer code;

    public PaperException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public PaperException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
