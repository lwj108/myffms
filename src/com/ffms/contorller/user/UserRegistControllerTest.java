package com.ffms.contorller.user;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.ffms.entity.FfmsResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UserRegistControllerTest {
	
	@Autowired//注入要测试的Controller
	private UserRegistController controller;
	//发�?执行测试请求
	private MockMvc mockMvc;
	
	@Before
	public void init(){
		mockMvc = MockMvcBuilders
			.standaloneSetup(controller).build();
	}
	
	@Test
	public void test1() throws Exception{
		RequestBuilder request = 
			MockMvcRequestBuilders
			.post("/user/regist.do")
			.param("cn_user_name", "my1")
			.param("cn_user_password", "123456")
			.param("cn_user_desc", "my1");
		
		//发�?执行�?��HTTP请求
		MvcResult result = 
		  mockMvc.perform(request)
				.andDo(MockMvcResultHandlers.print())
				.andExpect(
				   MockMvcResultMatchers.status().isOk())
				.andReturn();//返回结果
		//提取响应信息中的json字符�?
		String jsonStr = result.getResponse()
				.getContentAsString();
		System.out.println(jsonStr);
		//将返回json字符串转成java对象
		ObjectMapper mapper = new ObjectMapper();
		FfmsResult FfmsResult = 
			mapper.readValue(jsonStr, FfmsResult.class);
		//使用断言判断
		Assert.assertEquals(0, FfmsResult.getStatus());
	}
	
//	@Test
//	public void test2() throws Exception{
//		RequestBuilder request = 
//			MockMvcRequestBuilders
//			.post("/user/regist.do")
//			.param("cn_user_name", "demo")
//			.param("cn_user_password", "123456")
//			.param("cn_user_desc", "demo");
//		
//		//发�?执行�?��HTTP请求
//		MvcResult result = mockMvc.perform(request)
//			.andDo(MockMvcResultHandlers.print())
//			.andExpect(
//				MockMvcResultMatchers.status().isOk())
//			.andReturn();//返回结果
//		//提取响应信息中的json字符�?
//		String jsonStr = result.getResponse()
//				.getContentAsString();
//		System.out.println(jsonStr);
//		//将返回json字符串转成java对象
//		ObjectMapper mapper = new ObjectMapper();
//		FfmsResult FfmsResult = 
//			mapper.readValue(jsonStr, FfmsResult.class);
//		//使用断言判断
//		Assert.assertEquals(1, FfmsResult.getStatus());
//	}
	
}
