package com.ulovecode.modules.item.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Accessors(chain = true)
@Data
public class
Item implements Serializable {
    @ApiModelProperty(value = "试题id",example = "7")
    private Integer itemId;

    @ApiModelProperty(value = "课程id",example = "1")
    private Integer courseId;

    @ApiModelProperty(value = "试题类型",example = "单选")
    private String itemType;

    @ApiModelProperty(value = "问题",example = "springmvc的怎么保存线程安全")
    private String question;

    @ApiModelProperty(value = "选项a",example = "通过ThreadLocal来保证线程安全")
    private String optiona;

    @ApiModelProperty(value = "选项b",example = "通过ThreadLocal来保证线程安全")
    private String optionb;

    @ApiModelProperty(value = "选项c", example = "通过ThreadLocal来保证线程安全")
    private String optionc;

    @ApiModelProperty(value = "选项d",example = "通过ThreadLocal来保证线程安全")
    private String optiond;

    private String optione;

    private String optionf;

    private String optiong;

    @ApiModelProperty(value = "答案",example = "a")
    private String answer;

    @ApiModelProperty(value = "难度",example = "4")
    private Integer difficulty;

    @ApiModelProperty(value = "知识点",example = "ThreadLocal在每个本地内存空间都会创建一个副本,修改的时候也是修改当前副本的内存空间")
    private String knowledge;
    @ApiModelProperty(value = "提示",example = "和Servlet机制是一样的")
    private String clue;

    @ApiModelProperty(value = "创建的时间")
    private Date recDtime;


}