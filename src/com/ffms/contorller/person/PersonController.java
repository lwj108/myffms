package com.ffms.contorller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	
	@RequestMapping("/loadpersons")
	@ResponseBody
	public FfmsResult execute(){
		FfmsResult result = personService.loadPerson();
		return result;
		
	}
	
	
}
