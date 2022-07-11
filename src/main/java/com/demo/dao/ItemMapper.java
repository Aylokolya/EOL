package com.demo.dao;

import com.demo.entity.Item;
import com.demo.entity.ItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemMapper {
    long countByExample(ItemExample example);

    int deleteByExample(ItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Item row);

    int insertSelective(Item row);

    List<Item> selectByExample(ItemExample example);

    Item selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") Item row, @Param("example") ItemExample example);

    int updateByExample(@Param("row") Item row, @Param("example") ItemExample example);

    int updateByPrimaryKeySelective(Item row);

    int updateByPrimaryKey(Item row);
}