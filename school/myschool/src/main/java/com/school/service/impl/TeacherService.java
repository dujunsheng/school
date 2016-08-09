/**
 * 
 */
package com.school.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.mapper.TeacherMapper;
import com.school.po.Teacher;
import com.school.po.TeacherExample;
import com.school.service.base.BaseService;
import com.school.util.CommonUtils;

/**
 * @author c116
 *
 */
@Service("TeacherServcie")
public class TeacherService implements BaseService<Teacher>{

	@Resource
	private TeacherMapper teacherMapper;
	
	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#insert(java.lang.Object)
	 */
	@Override
	public int insert(Teacher t) {
		// TODO Auto-generated method stub
		return teacherMapper.insert(t);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(Teacher t) {
		// TODO Auto-generated method stub
		return teacherMapper.insertSelective(t);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Teacher selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return teacherMapper.selectByPrimaryKey(id);
	}

	
//	多条件查询，分页
	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#selectByParameters(java.util.Map)
	 */
	@Override
	public List<Teacher> selectByParameters(Map<String, Object> map) {
		
		return teacherMapper.selectByExample(CommonUtils.toBean(map, TeacherExample.class));
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(Teacher t) {
		// TODO Auto-generated method stub
		return teacherMapper.updateByPrimaryKeySelective(t);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#updateByPrimaryKey(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKey(Teacher t) {
		// TODO Auto-generated method stub
		return teacherMapper.updateByPrimaryKey(t);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#selectAll(int, int)
	 */
	@Override
	public List<Teacher> selectAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return teacherMapper.deleteByPrimaryKey(id);
	}

}
