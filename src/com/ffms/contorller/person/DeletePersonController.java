package com.ffms.contorller.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.PersonService;



@Controller
@RequestMapping("/person")
public class DeletePersonController {
	@Autowired
	private PersonService personService;
	
	@RequestMapping("/deleteperson")
	@ResponseBody
	public FfmsResult execute(int pid){
		FfmsResult result = personService.deletePerson(pid);
		return result;
		
	}
}
