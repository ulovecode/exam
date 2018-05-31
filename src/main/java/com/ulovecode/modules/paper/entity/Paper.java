package com.ulovecode.modules.paper.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Accessors(chain = true)
@Data
@ApiModel("试卷信息")
public class
Paper implements Serializable {
    @ApiModelProperty(value = "试卷id",example = "12",position = 1)
    private Integer paperId;

    @ApiModelProperty(value = "课程id",example = "123",position = 2)
    private Integer courseId;

    @ApiModelProperty(value = "试卷标题",example = "112",position = 3)
    private String title;

    @ApiModelProperty(value = "成绩",example = "12",position = 4)
    private String grade;

    @ApiModelProperty(value = "考试阶段",example = "第一阶段",position = 5)
    private String stage;

    @ApiModelProperty(value = "考试时间",position = 6)
    private Date testdate;

    @ApiModelProperty(value = "试卷状态",example = "待审核",position = 7)
    private String pstatus;

    @ApiModelProperty(value = "描述",example = "这是xx年某月某日的考试",position = 8)
    private String descript;

    @ApiModelProperty(value = "试卷创建时间",position = 9)
    private Date papertime;

}