package com.school.dao.base;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	public int deleteByPrimaryKey(String id);

	public int insert(T t);

	public int insertSelective(T t);

	public T selectByPrimaryKey(String id);

	public List<T> selectByParameters(Map<String, Object> map);

	public int updateByPrimaryKeySelective(T t);

	public int updateByPrimaryKey(T t);

	public List<T> selectAll(int offset, int limit);
}
