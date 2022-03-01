package com.ctl.simple.mapper;

import com.ctl.simple.model.Word;
import com.ctl.simple.model.WordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ctl
 */
public interface WordMapper {
    long countByExample(WordExample example);

    int deleteByExample(WordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Word record);

    int insertSelective(Word record);

    List<Word> selectByExample(WordExample example);

    Word selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Word record, @Param("example") WordExample example);

    int updateByExample(@Param("record") Word record, @Param("example") WordExample example);

    int updateByPrimaryKeySelective(Word record);

    int updateByPrimaryKey(Word record);
}