package com.ffms.aop;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionLogger {

	@AfterThrowing(throwing="ex",
		pointcut="within(com.ffms.web.controller..*)")
	public void log(Exception ex){
		//记录异常对象
		try {
			FileWriter out = 
				new FileWriter("E:\\error.log",true);
			PrintWriter pw = new PrintWriter(out);
			pw.println("======异常信息如下=======");
			ex.printStackTrace(pw);
			pw.flush();
			pw.close();
			out.close();
		} catch (IOException e) {
			System.out.println("记录异常信息出错");
		}
	}
	
}
