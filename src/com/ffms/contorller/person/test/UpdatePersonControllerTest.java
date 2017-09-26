package com.ffms.contorller.person.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ffms.contorller.person.UpdatePersonController;
import com.ffms.entity.FfmsResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class UpdatePersonControllerTest {
	@Autowired
	private UpdatePersonController controller;
	
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
			.post("/person/updateperson.do")
			.param("pid", "15")
			.param("name","吴奇隆")
			.param("sex","男")
			.param("age","50")
			.param("identity","无")
			.param("birthday","1910-01-01")
			.param("telephone","无")
			.param("state","武者");
		MvcResult mvcResult = mockMvc.perform(request)
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andReturn();
		//获取响应信息
		String jsonStr = 
			mvcResult.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		FfmsResult FfmsResult = 
			mapper.readValue(jsonStr, FfmsResult.class);
		Assert.assertEquals(0, FfmsResult.getStatus());
	}
}
