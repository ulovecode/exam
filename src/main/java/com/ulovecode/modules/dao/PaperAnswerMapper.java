package com.ulovecode.modules.dao;

import com.ulovecode.modules.entity.domain.PaperAnswer;
import com.ulovecode.modules.entity.domain.PaperAnswerExample;
import com.ulovecode.modules.entity.domain.PaperAnswerKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PaperAnswerMapper {
    int countByExample(PaperAnswerExample example);

    int deleteByExample(PaperAnswerExample example);

    int deleteByPrimaryKey(PaperAnswerKey key);

    int insert(PaperAnswer record);

    int insertSelective(PaperAnswer record);

    List<PaperAnswer> selectByExample(PaperAnswerExample example);

    PaperAnswer selectByPrimaryKey(PaperAnswerKey key);

    int updateByExampleSelective(@Param("record") PaperAnswer record, @Param("example") PaperAnswerExample example);

    int updateByExample(@Param("record") PaperAnswer record, @Param("example") PaperAnswerExample example);

    int updateByPrimaryKeySelective(PaperAnswer record);

    int updateByPrimaryKey(PaperAnswer record);
}