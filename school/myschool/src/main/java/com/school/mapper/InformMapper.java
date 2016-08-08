package com.school.mapper;

import com.school.po.Inform;
import com.school.po.InformExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InformMapper {
    int countByExample(InformExample example);

    int deleteByExample(InformExample example);

    int deleteByPrimaryKey(Integer informId);

    int insert(Inform record);

    int insertSelective(Inform record);

    List<Inform> selectByExampleWithBLOBs(InformExample example);

    List<Inform> selectByExample(InformExample example);

    Inform selectByPrimaryKey(Integer informId);

    int updateByExampleSelective(@Param("record") Inform record, @Param("example") InformExample example);

    int updateByExampleWithBLOBs(@Param("record") Inform record, @Param("example") InformExample example);

    int updateByExample(@Param("record") Inform record, @Param("example") InformExample example);

    int updateByPrimaryKeySelective(Inform record);

    int updateByPrimaryKeyWithBLOBs(Inform record);

    int updateByPrimaryKey(Inform record);
}