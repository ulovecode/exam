package com.ulovecode.modules.answer.entity.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemAnswer {

    private String paperId;

    private String itemId;

    private String question;

    private String optiona;

    private String optionb;

    private String optionc;

    private String optiond;

    private String optione;

    private String optionf;

    private String optiong;

    private String answer;


}
