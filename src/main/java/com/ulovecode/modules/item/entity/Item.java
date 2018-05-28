package com.ulovecode.modules.item.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
@Accessors(chain = true)
@Data
public class

Item implements Serializable {
    private Integer itemId;

    private Integer courseId;

    private String itemType;


    private String question;

    private String optiona;

    private String optionb;

    private String optionc;

    private String optiond;

    private String optione;

    private String optionf;

    private String optiong
            ;

    private String answer;


    private Integer difficulty;

    private String knowledge;

    private String clue;

    private Date recDtime;


}