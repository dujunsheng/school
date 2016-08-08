package com.school.mapper;

import com.school.po.Teacher_class;
import com.school.po.Teacher_classExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Teacher_classMapper {
    int countByExample(Teacher_classExample example);

    int deleteByExample(Teacher_classExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teacher_class record);

    int insertSelective(Teacher_class record);

    List<Teacher_class> selectByExample(Teacher_classExample example);

    Teacher_class selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teacher_class record, @Param("example") Teacher_classExample example);

    int updateByExample(@Param("record") Teacher_class record, @Param("example") Teacher_classExample example);

    int updateByPrimaryKeySelective(Teacher_class record);

    int updateByPrimaryKey(Teacher_class record);
}