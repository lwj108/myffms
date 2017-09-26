package com.ffms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffms.dao.PersonDao;
import com.ffms.entity.FfmsResult;
import com.ffms.entity.Person;
import com.ffms.service.PersonService;

@Service
@Transactional
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonDao personDao;

	/**
	 * 加载成员
	 */
	public FfmsResult loadPerson() {
		FfmsResult result = new FfmsResult();
		
		List<Person> list = personDao.findAll();
		result.setData(list);
	
		result.setStatus(0);
		result.setMsg("加载成员成功");
		return result;
	}

	
	/**
	 * 删除成员
	 */
	public FfmsResult deletePerson(int pid){
		FfmsResult result = new FfmsResult();
		personDao.delete(pid);
		result.setStatus(0);
		result.setMsg("删除成员成功");
		return result;
	}

	/**
	 * 修改成员信息
	 */
	public FfmsResult update(int pid, String name, String sex, int age,
			String identity, String birthday, String telephone, String state) {
		FfmsResult result = new FfmsResult();
		Person person = new Person();
		person.setPid(pid);
		person.setName(name);
		person.setSex(sex);
		person.setAge(age);
		person.setIdentity(identity);
		person.setBirthday(birthday);
		person.setTelephone(telephone);
		person.setState(state);
		personDao.update(person);
		result.setStatus(0);
		result.setMsg("修改成员成功");
		result.setData(person);
		return result;
	}

	/**
	 * 添加成员
	 */
	public FfmsResult create(String name, String sex, int age, String identity,
			String birthday, String telephone, String state) {
		FfmsResult result = new FfmsResult();
		Person person = new Person();
		person.setName(name);
		person.setSex(sex);
		person.setAge(age);
		person.setIdentity(identity);
		person.setBirthday(birthday);
		person.setTelephone(telephone);
		person.setState(state);
		personDao.add(person);
		result.setStatus(0);
		result.setMsg("添加成员成功");
		result.setData(person);
		return result;
	}


	
	

}
