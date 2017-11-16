package com.platform.base.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.platform.base.dao.BaseDao;
import com.platform.base.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

	@Autowired
	private BaseDao<T> baseDaoImpl;
	
	@Override
	public T get(String id) {
		return  baseDaoImpl.get(id);
	}

	@Override
	public Integer update(T entity) {		
		return baseDaoImpl.update(entity);
	}

	@Override
	public Integer insert(T entity) {
		return baseDaoImpl.insert(entity);
	}

	@Override
	public Integer delete(T entity) {
		return baseDaoImpl.delete(entity);
	}

	@Override
	public Integer persist(T entity) {
		return baseDaoImpl.persist(entity);
	}

	@Override
	public List<T> selectList(Map<String, Object> params) {
		return baseDaoImpl.selectList(params);
	}

}
