package com.ulovecode.modules.answer.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Accessors(chain = true)

@Data
public class PaperAnswer extends PaperAnswerKey implements Serializable {
    private String answer;

    private String answer2;

    private String note;

    public String getAnswer() {
        return answer;
    }
}