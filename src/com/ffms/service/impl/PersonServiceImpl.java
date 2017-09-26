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
	 * ���س�Ա
	 */
	public FfmsResult loadPerson() {
		FfmsResult result = new FfmsResult();
		
		List<Person> list = personDao.findAll();
		result.setData(list);
	
		result.setStatus(0);
		result.setMsg("���س�Ա�ɹ�");
		return result;
	}

	
	/**
	 * ɾ����Ա
	 */
	public FfmsResult deletePerson(int pid){
		FfmsResult result = new FfmsResult();
		personDao.delete(pid);
		result.setStatus(0);
		result.setMsg("ɾ����Ա�ɹ�");
		return result;
	}

	/**
	 * �޸ĳ�Ա��Ϣ
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
		result.setMsg("�޸ĳ�Ա�ɹ�");
		result.setData(person);
		return result;
	}

	/**
	 * ��ӳ�Ա
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
		result.setMsg("��ӳ�Ա�ɹ�");
		result.setData(person);
		return result;
	}


	
	

}
