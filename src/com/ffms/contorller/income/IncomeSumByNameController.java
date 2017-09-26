package com.ffms.contorller.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.IncomeService;

@Controller
@RequestMapping("/income")
public class IncomeSumByNameController {
	
	@Autowired
	private IncomeService incomeService;
	
	@RequestMapping("/incomesumbyname")
	@ResponseBody
	public FfmsResult execute(String name){
		FfmsResult result = incomeService.sumbyname(name);
		return result;
	}
}
