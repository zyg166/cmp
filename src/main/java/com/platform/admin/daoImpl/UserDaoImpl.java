package com.platform.admin.daoImpl;

import org.springframework.stereotype.Repository;

import com.platform.admin.dao.UserDao;
import com.platform.admin.domain.User;
import com.platform.base.daoImpl.BaseDaoImpl;

@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{
	
}
