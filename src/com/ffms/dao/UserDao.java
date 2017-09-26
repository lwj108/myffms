package com.ffms.dao;

import java.util.Map;

import com.ffms.entity.User;


public interface UserDao {
	public User findByName(String name);
	public int save(User user);
	public int updateToken(Map<String,Object> params);
}