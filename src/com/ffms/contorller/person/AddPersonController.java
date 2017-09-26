package com.ffms.contorller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.PersonService;

@Controller
@RequestMapping("/person")
public class AddPersonController {

	@Autowired
	private PersonService personSerive;
	
	@RequestMapping("/addperson")
	@ResponseBody
	public FfmsResult execute(String name,String sex,int age,String identity,String birthday,String telephone,String state){
		System.out.println(name);
		FfmsResult result = personSerive.create( name, sex, age, identity, birthday, telephone, state);
		
		return result;
		
	}
}
