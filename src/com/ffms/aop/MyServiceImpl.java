package com.ffms.aop;

import org.springframework.stereotype.Service;

@Service("myservice")
public class MyServiceImpl implements MyService{

	public void f1() {
		System.out.println("执行f1业务处理");
	}

	public void f2() {
		System.out.println("执行f2业务处理");
	}

}
