package com.demo.dao;

import com.demo.entity.Question;
import com.demo.entity.QuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuestionMapper {
    long countByExample(QuestionExample example);

    int deleteByExample(QuestionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Question row);

    int insertSelective(Question row);

    List<Question> selectByExample(QuestionExample example);

    Question selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Question row, @Param("example") QuestionExample example);

    int updateByExample(@Param("row") Question row, @Param("example") QuestionExample example);

    int updateByPrimaryKeySelective(Question row);

    int updateByPrimaryKey(Question row);
}