/**
 * 
 */
package com.school.service.base;

import java.util.List;
import java.util.Map;

/**
 * @author 杜俊笙
 *
 */
public interface BaseService<T>{
	
	int insert(T t);
	
	int insertSelective(T t);
	
	T selectByPrimaryKey(String id);
	
	List<T> selectByParameters(Map<String, Object> map);
	
	int updateByPrimaryKeySelective(T t);
	
	int updateByPrimaryKey(T t);
	
	List<T> selectAll(int offset, int limit);
	
	int deleteByPrimaryKey(String id);
}


