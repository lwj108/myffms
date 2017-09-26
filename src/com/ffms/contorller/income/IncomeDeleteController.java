package com.ffms.contorller.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.IncomeService;

@Controller
@RequestMapping("income")
public class IncomeDeleteController {
	@Autowired
	private IncomeService incomeService;
	
	@RequestMapping("/deleteincome")
	@ResponseBody
	public FfmsResult execute(int iid){
		FfmsResult result = incomeService.deleteIncome(iid);
		return result;
		
	}
}
