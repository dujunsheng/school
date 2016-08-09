package com.school.mapper;

import com.school.dao.base.BaseDao;
import com.school.po.Department;
import com.school.po.DepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper extends BaseDao<Department>{
    int countByExample(DepartmentExample example);

    int deleteByExample(DepartmentExample example);

    int deleteByPrimaryKey(Integer depId);

    int insert(Department record);

    int insertSelective(Department record);

    List<Department> selectByExample(DepartmentExample example);

    Department selectByPrimaryKey(Integer depId);

    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    
    //应用于分页查询所有
    List<Department> findAll();
}