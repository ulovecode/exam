package com.ulovecode.modules.answer.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;


@ApiModel(description = "考生及试卷信息")
public class PaperAnswerKey implements Serializable {
    @ApiModelProperty(value = "试卷Id", example = "52",position = 1)
    private Integer paperId;

    @ApiModelProperty(value = "试题Id", example = "2",position = 2)
    private Integer itemId;

    @ApiModelProperty(value = "学号Id", example = "1111",position = 3)
    private String sno;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno == null ? null : sno.trim();
    }
}