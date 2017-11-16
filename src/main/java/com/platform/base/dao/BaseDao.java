package com.platform.base.dao;

import java.util.List;
import java.util.Map;


public interface BaseDao<T> {	
	T get(String id);
	Integer update(T entity);
	Integer insert(T entity);
	Integer delete(T entity);
	Integer persist(T entity);
	List<T> selectList(Map<String,Object> params);	
}
