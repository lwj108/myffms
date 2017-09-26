package com.ffms.contorller.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.IncomeService;

@Controller
@RequestMapping("/income")
public class IncomeController {
	
	@Autowired
	private IncomeService incomeService;
	
	@RequestMapping("/loadincome")
	@ResponseBody
	public FfmsResult execute(){
		FfmsResult result = incomeService.loadIncome();
		return result;
	}
}
