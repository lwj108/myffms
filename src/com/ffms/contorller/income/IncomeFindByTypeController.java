package com.ffms.contorller.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.IncomeService;

@Controller
@RequestMapping("/income")
public class IncomeFindByTypeController {

	@Autowired
	private IncomeService incomeService;
	
	@RequestMapping("/incomefindbytype")
	@ResponseBody
	public FfmsResult execute(String itype){
		System.out.println(itype);
		FfmsResult result = incomeService.findbytype(itype);
		return result;
	}
	
}