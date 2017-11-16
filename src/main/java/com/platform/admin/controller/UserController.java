package com.platform.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.platform.admin.domain.User;
import com.platform.admin.service.UserService;
import com.platform.base.controller.BaseController;
@Controller
@RequestMapping("/u")
public class UserController extends BaseController{
	private static final Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	private UserService userServiceImpl;
	@ResponseBody
	@RequestMapping(value="c",method=RequestMethod.GET)
	public String insert(String name,String id){
		logger.info("this is  the parameter[name] :"+name);			
		User user = new User();
		user.setName(name);
		user.setId(id);
		Integer n = userServiceImpl.persist(user);
		logger.info("insert "+ n +" rows ===========================");
		return n.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="r",method=RequestMethod.GET)
	public String select(String name){
		logger.info("this is  the parameter[name] :"+name);
		Map<String,Object> params = new HashMap<String,Object>();
		params.put("name", name);
		JSONArray a = new JSONArray(userServiceImpl.selectList(params));
		return a.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="u",method=RequestMethod.GET)
	public String update(String id,String name){
		logger.info("this is  the parameter[name] :"+name);
		User user = new User();
		user.setName(name);
		user.setId(id);
		Integer n = userServiceImpl.persist(user);
		logger.info(" persist "+ n +" rows");	
		return "hello "+name;
	}
	@ResponseBody
	@RequestMapping(value="d",method=RequestMethod.GET)
	public String delete(String id,String name){
		logger.info("this is  the parameter[name] :"+name);
		User user = new User();
		user.setName(name);
		user.setId(id);
		Integer n = userServiceImpl.delete(user);
		logger.info(" delete "+ n +" rows");		
		return "hello "+name;
	}
	
}
