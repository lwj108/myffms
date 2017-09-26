package com.ffms.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component//扫描到Spring
@Aspect//将该组件定义成切�?
public class MyAopBean1 {

   @Before("within(com.ffms.aop.MyServiceImpl)")
   public void log(){
	   System.out.println("跟踪日志操作");
   }
}
