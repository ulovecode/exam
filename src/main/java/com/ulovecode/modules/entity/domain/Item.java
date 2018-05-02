package com.ulovecode.modules.entity.domain;

import java.io.Serializable;
import java.util.Date;

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

    private String optiong;

    private String answer;

    private Integer difficulty;

    private String knowledge;

    private String clue;

    private Date recDtime;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType == null ? null : itemType.trim();
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getOptiona() {
        return optiona;
    }

    public void setOptiona(String optiona) {
        this.optiona = optiona == null ? null : optiona.trim();
    }

    public String getOptionb() {
        return optionb;
    }

    public void setOptionb(String optionb) {
        this.optionb = optionb == null ? null : optionb.trim();
    }

    public String getOptionc() {
        return optionc;
    }

    public void setOptionc(String optionc) {
        this.optionc = optionc == null ? null : optionc.trim();
    }

    public String getOptiond() {
        return optiond;
    }

    public void setOptiond(String optiond) {
        this.optiond = optiond == null ? null : optiond.trim();
    }

    public String getOptione() {
        return optione;
    }

    public void setOptione(String optione) {
        this.optione = optione == null ? null : optione.trim();
    }

    public String getOptionf() {
        return optionf;
    }

    public void setOptionf(String optionf) {
        this.optionf = optionf == null ? null : optionf.trim();
    }

    public String getOptiong() {
        return optiong;
    }

    public void setOptiong(String optiong) {
        this.optiong = optiong == null ? null : optiong.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge == null ? null : knowledge.trim();
    }

    public String getClue() {
        return clue;
    }

    public void setClue(String clue) {
        this.clue = clue == null ? null : clue.trim();
    }

    public Date getRecDtime() {
        return recDtime;
    }

    public void setRecDtime(Date recDtime) {
        this.recDtime = recDtime;
    }
}