package com.ulovecode.modules.exception;

import com.ulovecode.modules.enums.ResultEnum;

public class ItemException extends RuntimeException {
    private Integer code;

    public ItemException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public ItemException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
