package com.ulovecode.modules.entity.domain;

import java.io.Serializable;

public class PaperAnswerKey implements Serializable {
    private Integer paperId;

    private Integer itemId;

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