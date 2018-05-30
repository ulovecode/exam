package com.ulovecode.modules.course.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Accessors(chain = true)
@Data
@ApiModel("课程信息")
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    @ApiModelProperty(value = "课程id",example = "21",position = 1)
    private Integer courseId;
    @ApiModelProperty(value = "课程名称",example = "21",position = 2)
    private String cname;
    @ApiModelProperty(value = "课程类型",example = "21",position = 3)
    private String ctype;
    @ApiModelProperty(value = "成绩",example = "21",position = 4)
    private Integer credit;
    @ApiModelProperty(value = "课程课时",example = "21",position = 5)
    private Integer times;
    @ApiModelProperty(value = "学期",example = "21",position = 6)
    private String stage;
    @ApiModelProperty(value = "课程描述",example = "21",position = 7)
    private String descript;
}