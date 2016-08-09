/**
 * 
 */
package com.school.service.base.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.school.dao.base.impl.BaseDaoImpl;
import com.school.service.base.BaseService;


/**
 * @author c116
 *
 */
@Service("BaseService")
public class BaseServiceImpl<T> implements BaseService<T> {
	
	@Resource
	private BaseDaoImpl<T> baseDaoImpl;
	
	public int insert(T t){
		return baseDaoImpl.insert(t);
	}
	
	public int insertSelective(T t){
		return baseDaoImpl.insertSelective(t);
	}
	
	public T selectByPrimaryKey(String id){
		return baseDaoImpl.selectByPrimaryKey(id);
	}
	
	public List<T> selectByParameters(Map<String, Object> map){
		return baseDaoImpl.selectByParameters(map);
	}
	
	public int updateByPrimaryKeySelective(T t){
		return baseDaoImpl.updateByPrimaryKeySelective(t);
	}
	
	public int updateByPrimaryKey(T t){
		return baseDaoImpl.updateByPrimaryKey(t);
	}
	
	public List<T> selectAll(int offset, int limit){
		return baseDaoImpl.selectAll(offset, limit);
	}
	
}
