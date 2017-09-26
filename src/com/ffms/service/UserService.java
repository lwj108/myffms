package com.ffms.service;

import com.ffms.entity.FfmsResult;
import com.ffms.entity.User;


public interface UserService {
	public FfmsResult checkLogin(
			String name,String password);
	
	public FfmsResult checkLogin(
			String author);
	
	public FfmsResult registUser(User user);
}



