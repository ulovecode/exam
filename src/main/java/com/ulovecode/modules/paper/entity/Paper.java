package com.ulovecode.modules.paper.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

@Accessors(chain = true)
@Data
public class
Paper implements Serializable {
    private Integer paperId;

    private Integer courseId;

    private String title;

    private String grade;

    private String stage;

    private Date testdate;

    private String pstatus;

    private String descript;

    private Date papertime;

}