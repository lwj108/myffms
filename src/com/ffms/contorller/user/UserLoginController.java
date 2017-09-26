package com.ffms.contorller.user;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserLoginController {
	@Autowired
	private UserService userService;
	
	//对应/user/login.do
	@RequestMapping("/login")
	@ResponseBody
	public FfmsResult execute(HttpServletRequest request){
		//获取请求头身份信息
		String author = 
			request.getHeader("Authorization");
		FfmsResult result = 
			userService.checkLogin(author);
		return result;
	}
	
}
