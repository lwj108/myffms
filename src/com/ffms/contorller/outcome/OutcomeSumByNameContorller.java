package com.ffms.contorller.outcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.OutcomeService;

@Controller
@RequestMapping("/outcome")
public class OutcomeSumByNameContorller {
	
	@Autowired
	private OutcomeService outcomeService;
	
	@RequestMapping("/outcomesumbyname")
	@ResponseBody
	public FfmsResult execute(String name){
		FfmsResult result = outcomeService.sumbyname(name);
		return result;
	}
}