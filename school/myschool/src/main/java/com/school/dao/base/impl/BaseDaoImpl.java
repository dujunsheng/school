package com.school.dao.base.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

import com.school.dao.base.BaseDao;
import com.school.util.NameSpaceUtil;

public class BaseDaoImpl<T> implements BaseDao<T> {

	@Resource(name = "sqlSessionTemplate")
	protected SqlSessionTemplate template;

	private static final String DELETEBYPRIMARYKEY = "deleteByPrimaryKey";
	private static final String INSERT = "insert";
	private static final String INSERTSELECTIVE = "insertSelective";
	private static final String SELECTBYPRIMARYKEY = "selectByPrimaryKey";
	private static final String UPDATEBYPRIMARYKEYSELECTIVE = "updateByPrimaryKeySelective";
	private static final String UPDATEBYPRIMARYKEY = "updateByPrimaryKey";
	private static final String SELECTALL = "selectAll";
	
	public int deleteByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		 return template.delete(getStatement(DELETEBYPRIMARYKEY), id);
	}

	public int insert(T t) {
		// TODO Auto-generated method stub
		return template.insert(getStatement(INSERT), t);
	}

	public int insertSelective(T t) {
		// TODO Auto-generated method stub
		return template.insert(getStatement(INSERTSELECTIVE), t);
	}

	public T selectByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		return template.selectOne(getStatement(SELECTBYPRIMARYKEY), id);
	}

	public List<T> selectByParameters(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return template.selectList(getStatement(UPDATEBYPRIMARYKEYSELECTIVE), map);
	}

	public int updateByPrimaryKeySelective(T t) {
		// TODO Auto-generated method stub
		return template.update(getStatement(UPDATEBYPRIMARYKEYSELECTIVE), t);
	}

	public int updateByPrimaryKey(T t) {
		// TODO Auto-generated method stub
		return template.update(getStatement(UPDATEBYPRIMARYKEY), t);
	}

	public List<T> selectAll(int offset, int limit) {
		// TODO Auto-generated method stub
		return template.selectList(getStatement(SELECTALL), null,
				new RowBounds(offset, limit));
	}
	
	protected String getStatement(String xmlId) {
		
		return getNameSpace() + "." + xmlId;
	}

	protected String getNameSpace() {
		return NameSpaceUtil.getNameSpace(getEntityClass().getName());
	}

	@SuppressWarnings("unchecked")
	protected Class<T> getEntityClass() {
		
		return (Class<T>) ((ParameterizedType) this.getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

}
