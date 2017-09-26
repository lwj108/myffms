package com.ffms.service;

import com.ffms.entity.FfmsResult;

public interface PersonService {
	public FfmsResult loadPerson();
	public FfmsResult deletePerson(int pid);
	public FfmsResult update(int pid,String name,String sex,int age,String identity,String birthday,String telephone,String state);
	public FfmsResult create(String name,String sex,int age,String identity,String birthday,String telephone,String state);
	
}
