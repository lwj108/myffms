package com.ffms.contorller.outcome;

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
import com.ffms.contorller.income.IncomeUpdateController;
import com.ffms.entity.FfmsResult;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class OutcomeUpdateControllerTest {
	@Autowired
	private OutcomeUpdateController controller;
	
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
			.post("/outcome/updateoutcome.do")
			.param("oid", "10")
			.param("name", "李益全")
			.param("otype", "工资")
			.param("oname", "王炸")
			.param("money", "6000")
			.param("oway", "面付")
			.param("time", "2017-01-01");
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
