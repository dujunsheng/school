package com.school.mapper;

import com.school.po.Campus_resource;
import com.school.po.Campus_resourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Campus_resourceMapper {
    int countByExample(Campus_resourceExample example);

    int deleteByExample(Campus_resourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Campus_resource record);

    int insertSelective(Campus_resource record);

    List<Campus_resource> selectByExample(Campus_resourceExample example);

    Campus_resource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Campus_resource record, @Param("example") Campus_resourceExample example);

    int updateByExample(@Param("record") Campus_resource record, @Param("example") Campus_resourceExample example);

    int updateByPrimaryKeySelective(Campus_resource record);

    int updateByPrimaryKey(Campus_resource record);
}