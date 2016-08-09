/**
 * 
 */
package com.school.service.impl;


import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.school.mapper.DepartmentMapper;
import com.school.po.Department;
import com.school.po.DepartmentExample;
import com.school.service.base.BaseService;
import com.school.util.CommonUtils;
import com.school.util.PageBean;
import com.school.util.PaginationContext;

/**
 * @author c116
 *
 */
@Service("DepartmentService")
public class DepartmentService implements BaseService<Department>{

	@Resource
	private DepartmentMapper departmentMapper;

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#insert(java.lang.Object)
	 */
	@Override
	public int insert(Department t) {
		// TODO Auto-generated method stub
		return departmentMapper.insert(t);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#insertSelective(java.lang.Object)
	 */
	@Override
	public int insertSelective(Department t) {
		// TODO Auto-generated method stub
		return departmentMapper.insertSelective(t);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#selectByPrimaryKey(java.lang.String)
	 */
	@Override
	public Department selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return departmentMapper.selectByPrimaryKey(Integer.valueOf(id));
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#selectByParameters(java.util.Map)
	 */
	@Override
	public List<Department> selectByParameters(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return departmentMapper.selectByExample(CommonUtils.toBean(map, DepartmentExample.class));
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#updateByPrimaryKeySelective(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKeySelective(Department t) {
		// TODO Auto-generated method stub
		return departmentMapper.updateByPrimaryKeySelective(t);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#updateByPrimaryKey(java.lang.Object)
	 */
	@Override
	public int updateByPrimaryKey(Department t) {
		// TODO Auto-generated method stub
		return departmentMapper.updateByPrimaryKey(t);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#selectAll(int, int)
	 */
	@Override
	public List<Department> selectAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//分页查询所有记录
	
	public PageBean<Department> findAll(){
		 PageHelper.startPage(PaginationContext.getPageNum(), 
				 PaginationContext.getPageSize());
		 List<Department> result = departmentMapper.findAll();
		 PageBean<Department> pb = new PageBean<Department>();
		 pb.setBeanList(result);
		 return pb;
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return departmentMapper.deleteByPrimaryKey(Integer.valueOf(id));
		}
}
