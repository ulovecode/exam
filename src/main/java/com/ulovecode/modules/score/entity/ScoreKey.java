package com.ulovecode.modules.score.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ScoreKey {
    private Integer paperId;

    private String sno;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreKey scoreKey = (ScoreKey) o;
        return Objects.equals(paperId, scoreKey.paperId) &&
                Objects.equals(sno, scoreKey.sno);
    }

    @Override
    public int hashCode() {

        return Objects.hash(paperId, sno);
    }
}