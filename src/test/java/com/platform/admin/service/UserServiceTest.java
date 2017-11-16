package com.platform.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.platform.admin.domain.User;

@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration("classpath:applicationContext.xml") 
public class UserServiceTest {
	@Autowired
	private UserService userServiceImpl;
	
	@Test
	public void testUserService(){
		Assert.assertNotNull(userServiceImpl);
		User entity = new User();
		entity.flushId();
		entity.setName("entity");
		int n = userServiceImpl.insert(entity);
		
		Assert.assertEquals(1, n);
		User user = userServiceImpl.get("1232");
		Assert.assertNotNull(user);
		
		Assert.assertEquals(user.getId(), "1232");
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name", "zyg");
		List<User> users = userServiceImpl.selectList(params);
		Assert.assertNotNull(users);
		Assert.assertEquals(1, users.size());
		
		User updateUser = new User();
		updateUser.setId("1232");
		updateUser.setName("zzzzz");
		int uNum = userServiceImpl.update(updateUser);
		Assert.assertEquals(1, uNum);		
		
	}
}
