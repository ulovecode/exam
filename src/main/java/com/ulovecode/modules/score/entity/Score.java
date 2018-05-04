package com.ulovecode.modules.score.entity;

import java.io.Serializable;

public class Score extends ScoreKey implements Serializable {
    private Integer ansnum;

    private Integer correct;

    private Integer score;

    public Integer getAnsnum() {
        return ansnum;
    }

    public void setAnsnum(Integer ansnum) {
        this.ansnum = ansnum;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}