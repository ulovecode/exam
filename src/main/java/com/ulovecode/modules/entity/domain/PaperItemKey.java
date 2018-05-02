package com.ulovecode.modules.entity.domain;

import java.io.Serializable;

public class PaperItemKey implements Serializable {
    private Integer paperId;

    private Integer itemId;

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
}