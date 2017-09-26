package com.ffms.aop;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyService {
	
	private MyService myservice;
	
	@Before
	public void init(){
		String conf = "com/ffms/aop/spring-aop-annotation.xml";
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext(conf);
		myservice = ac.getBean("myservice",MyService.class);
	}
	
	@Test
	public void test1(){
		myservice.f1();
	}
	
	@Test
	public void test2(){
		myservice.f2();
	}
	
	
	
	
	
}
