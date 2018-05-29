package com.ulovecode.modules.answer.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Accessors(chain = true)
@Data
@ApiModel(description = "试卷答案")
public class PaperAnswer extends PaperAnswerKey implements Serializable {
    @ApiModelProperty(value = "答案", example = "a",position = 3)
    private String answer;

    @ApiModelProperty(value = "答案2", example = "a,b",position = 4)
    private String answer2;

    @ApiModelProperty(value = "考试状态", example = "正考",position = 5)
    private String note;


}