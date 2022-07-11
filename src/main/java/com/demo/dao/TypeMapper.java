package com.demo.dao;

import com.demo.entity.Type;
import com.demo.entity.TypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TypeMapper {
    long countByExample(TypeExample example);

    int deleteByExample(TypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Type row);

    int insertSelective(Type row);

    List<Type> selectByExample(TypeExample example);

    Type selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Type row, @Param("example") TypeExample example);

    int updateByExample(@Param("row") Type row, @Param("example") TypeExample example);

    int updateByPrimaryKeySelective(Type row);

    int updateByPrimaryKey(Type row);
}