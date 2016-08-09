/**
 * 
 */
package com.school.service.base.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.school.dao.base.BaseDao;
import com.school.service.base.BaseService;


/**
 * @author c116
 *
 */
public class BaseServiceImpl<T> implements BaseService<T>{
	
	@Resource
	private BaseDao<T> baseDao;
	
	public int insert(T t){
		return baseDao.insert(t);
	}
	
	public int insertSelective(T t){
		return baseDao.insertSelective(t);
	}
	
	public T selectByPrimaryKey(String id){
		return baseDao.selectByPrimaryKey(id);
	}
	
	public List<T> selectByParameters(Map<String, Object> map){
		return baseDao.selectByParameters(map);
	}
	
	public int updateByPrimaryKeySelective(T t){
		return baseDao.updateByPrimaryKeySelective(t);
	}
	
	public int updateByPrimaryKey(T t){
		return baseDao.updateByPrimaryKey(t);
	}
	
	public List<T> selectAll(int offset, int limit){
		return baseDao.selectAll(offset, limit);
	}

	/* (non-Javadoc)
	 * @see com.school.service.base.BaseService#deleteByPrimaryKey(java.lang.String)
	 */
	@Override
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return baseDao.deleteByPrimaryKey(id);
	}
	
}
