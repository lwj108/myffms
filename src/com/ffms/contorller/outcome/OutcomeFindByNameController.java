package com.ffms.contorller.outcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.OutcomeService;

@Controller
@RequestMapping("/outcome")
public class OutcomeFindByNameController {

	@Autowired
	private OutcomeService outcomeService;
	
	@RequestMapping("/outcomefindbyname")
	@ResponseBody
	public FfmsResult execute(String name){
		System.out.println(name);
		FfmsResult result = outcomeService.findbyname(name);
		return result;
	}
	
}