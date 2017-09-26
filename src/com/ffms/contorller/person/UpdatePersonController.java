package com.ffms.contorller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.PersonService;

@Controller
@RequestMapping("/person")
public class UpdatePersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/updateperson")
	@ResponseBody
	public FfmsResult execute(int pid,String name,String sex,int age,String identity,String birthday,String telephone,String state){
		
		FfmsResult result = personService.update( pid, name, sex, age, identity, birthday, telephone, state);
		return result;
		
	}
}
