package com.ffms.contorller.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.IncomeService;
@Controller
@RequestMapping("/income")
public class IncomeFindByTimeController {
	@Autowired
	private IncomeService incomeService;
	
	@RequestMapping("/incomefindbytime")
	@ResponseBody
	public FfmsResult execute(String starttime,String endtime){
		System.out.println(starttime);
		System.out.println(endtime);
		FfmsResult result = incomeService.findbytime(starttime,endtime);
		return result;
	}
}
