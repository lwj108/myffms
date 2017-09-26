package com.ffms.dao;

import java.util.List;

import com.ffms.entity.Person;
public interface PersonDao {
	public int delete(int pid);
	public List<Person> findAll();
	public int update(Person person);
	public int add(Person person);
	//public Person findByPid(int pid);
	
}
