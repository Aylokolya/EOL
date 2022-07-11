package com.demo.dao;

import com.demo.entity.Major;
import com.demo.entity.MajorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MajorMapper {
    long countByExample(MajorExample example);

    int deleteByExample(MajorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Major row);

    int insertSelective(Major row);

    List<Major> selectByExample(MajorExample example);

    Major selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Major row, @Param("example") MajorExample example);

    int updateByExample(@Param("row") Major row, @Param("example") MajorExample example);

    int updateByPrimaryKeySelective(Major row);

    int updateByPrimaryKey(Major row);
}