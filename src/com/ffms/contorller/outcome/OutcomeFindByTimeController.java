package com.ffms.contorller.outcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.OutcomeService;

@Controller
@RequestMapping("/outcome")
public class OutcomeFindByTimeController {
	@Autowired
	private OutcomeService outcomeService;
	
	@RequestMapping("/outcomefindbytime")
	@ResponseBody
	public FfmsResult execute(String starttime,String endtime){
		System.out.println(starttime);
		System.out.println(endtime);
		FfmsResult result = outcomeService.findbytime(starttime,endtime);
		return result;
	}
}
