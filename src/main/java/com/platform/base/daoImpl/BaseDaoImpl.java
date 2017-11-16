package com.platform.base.daoImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import com.platform.base.dao.BaseDao;
import com.platform.base.domain.BaseDomain;


public abstract class BaseDaoImpl<T extends BaseDomain<?>> extends SqlSessionDaoSupport implements BaseDao<T> {	
	private Class<T> clazz;
	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate;
	@Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }
	@SuppressWarnings("unchecked")
	public BaseDaoImpl(){
		super();
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		clazz = (Class<T>) params[0];
	}
	@Override
	@SuppressWarnings("unchecked")
	public T get(String id) {
		return (T) sqlSessionTemplate.selectOne(clazz.getName()+".get",id);
	}

	@Override
	public Integer update(T entity) {	
		if(StringUtils.isBlank(entity.getId())){
			throw new RuntimeException("a entity to update must has an ID ");
		}
		return sqlSessionTemplate.update(clazz.getName()+".update",entity);
	}

	@Override
	public List<T> selectList(Map<String, Object> params) {		
		return sqlSessionTemplate.selectList(clazz.getName()+".selectList", params);
	}

	@Override
	public Integer insert(T entity) {
		entity.generateId();
		return sqlSessionTemplate.insert(clazz.getName()+".insert",entity);
	}

	@Override
	public Integer delete(T entity) {
		if(StringUtils.isBlank(entity.getId())){
			throw new RuntimeException("a entity to delete must has an ID ");
		}
		return sqlSessionTemplate.delete(clazz.getName()+".delete",entity);
	}
	@Override
	public Integer persist(T entity) {
		if(StringUtils.isNotBlank(entity.getId())){
			T oldEntity = this.get(entity.getId());
			if(oldEntity==null){
				return this.insert(entity);
			}
			return this.update(entity);
		}else{
			return this.insert(entity);
		}
	}
}
