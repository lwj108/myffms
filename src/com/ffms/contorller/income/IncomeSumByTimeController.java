package com.ffms.contorller.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.IncomeService;

@Controller
@RequestMapping("/income")
public class IncomeSumByTimeController {
	
	@Autowired
	private IncomeService incomeService;
	
	@RequestMapping("/incomesumbytime")
	@ResponseBody
	public FfmsResult execute(String starttime,String endtime){
		FfmsResult result = incomeService.sumbytime(starttime, endtime);
		return result;
	}
}

