package com.ffms.contorller.outcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.OutcomeService;

@Controller
@RequestMapping("/outcome")
public class OutcomeSumByTimeController {
	
	@Autowired
	private OutcomeService outcomeService;
	
	@RequestMapping("/outcomesumbytime")
	@ResponseBody
	public FfmsResult execute(String starttime,String endtime){
		FfmsResult result = outcomeService.sumbytime(starttime, endtime);
		return result;
	}
}
