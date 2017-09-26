package com.ffms.contorller.income;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.IncomeService;

@Controller
@RequestMapping("/income")
public class IncomeFindByNameController {

	@Autowired
	private IncomeService incomeService;
	
	@RequestMapping("/incomefindbyname")
	@ResponseBody
	public FfmsResult execute(String name){
		System.out.println(name);
		FfmsResult result = incomeService.findbyname(name);
		return result;
	}
	
}
