package com.ulovecode.modules.paper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Accessors(chain = true)
@Data
@ApiModel("试卷试题关联信息")
public class PaperItemKey implements Serializable {
    @ApiModelProperty(value = "试卷id",example = "12",position = 1)
    private Integer paperId;
    @ApiModelProperty(value = "试题id",example = "12",position = 1)
    private Integer itemId;

}