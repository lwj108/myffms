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
import com.ffms.contorller.person.AddPersonController;
import com.ffms.entity.FfmsResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class AddPersonControllerTest {
	@Autowired
	private AddPersonController controller;
	
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
			.post("/person/addperson.do")
			.param("name","������")
			.param("sex","��")
			.param("age","50")
			.param("identity","��")
			.param("birthday","1210-01-01")
			.param("telephone","��")
			.param("state","�ʵ�");
		MvcResult mvcResult = mockMvc.perform(request)
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andReturn();
		//��ȡ��Ӧ��Ϣ
		String jsonStr = 
			mvcResult.getResponse().getContentAsString();
		ObjectMapper mapper = new ObjectMapper();
		FfmsResult FfmsResult = 
			mapper.readValue(jsonStr, FfmsResult.class);
		Assert.assertEquals(0, FfmsResult.getStatus());
	}
}
