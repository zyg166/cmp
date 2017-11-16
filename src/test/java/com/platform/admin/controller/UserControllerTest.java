package com.platform.admin.controller;

import javax.servlet.ServletContext;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class) 
@WebAppConfiguration
@ContextConfiguration("classpath:applicationContext.xml") 
public class UserControllerTest {
	
	@Autowired  
	UserController userController;  
	  
	@Autowired  
	ServletContext context;  
	  
	MockMvc mockMvc;  
	
	@Before  
	public void setup(){  
	    mockMvc = MockMvcBuilders.standaloneSetup(userController).build();  
	}  
	
	@Test
	public void testInsert() throws Exception{		
		  ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.get("/u/c.do")  
	                .accept(MediaType.APPLICATION_JSON).param("id","1232").param("name", "zyg"));  
	        MvcResult mvcResult = resultActions.andReturn();  
	        String result = mvcResult.getResponse().getContentAsString();  
	        Assert.assertEquals(result, "1");
	}
	
	@After  
	public void destory(){  
	    
	}  
	
}
