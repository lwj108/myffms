package com.ffms.contorller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.entity.User;
import com.ffms.service.UserService;

@Controller
@RequestMapping("/user")
public class UserRegistController {
	
	@Autowired
	private UserService userService;
	
	//对应/user/regist.do
	@RequestMapping("/regist")
	@ResponseBody
	public FfmsResult execute(User user){
		FfmsResult result = 
			userService.registUser(user);
		System.out.println(result.getStatus() + result.getMsg());
		return result;
	}
	
}
