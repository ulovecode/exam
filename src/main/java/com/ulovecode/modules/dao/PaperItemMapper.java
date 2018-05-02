package com.ulovecode.modules.dao;

import com.ulovecode.modules.entity.domain.PaperItemExample;
import com.ulovecode.modules.entity.domain.PaperItemKey;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PaperItemMapper {
    int countByExample(PaperItemExample example);

    int deleteByExample(PaperItemExample example);

    int deleteByPrimaryKey(PaperItemKey key);

    int insert(PaperItemKey record);

    int insertSelective(PaperItemKey record);

    List<PaperItemKey> selectByExample(PaperItemExample example);

    int updateByExampleSelective(@Param("record") PaperItemKey record, @Param("example") PaperItemExample example);

    int updateByExample(@Param("record") PaperItemKey record, @Param("example") PaperItemExample example);
}