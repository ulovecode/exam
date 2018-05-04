package com.ulovecode.modules.score.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Accessors(chain = true)
@Data
public class Score extends ScoreKey implements Serializable {
    private Integer ansnum;

    private Integer correct;

    private Integer score;


}