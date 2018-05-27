package com.ulovecode.modules.paper.dao;

import com.ulovecode.modules.item.entity.Item;
import com.ulovecode.modules.paper.entity.PaperItemExample;
import com.ulovecode.modules.paper.entity.PaperItemKey;
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

    List<Item>  selectByPaperId(Integer paperId);
}