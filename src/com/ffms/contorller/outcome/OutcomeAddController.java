package com.ffms.contorller.outcome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.OutcomeService;

@Controller
@RequestMapping("/outcome")
public class OutcomeAddController {
	
	@Autowired
	private OutcomeService outcomeService;
	
	@RequestMapping("/addoutcome")
	@ResponseBody
	public FfmsResult execute(String name, String otype, String oname,
			String money, String oway, String time){
		FfmsResult result = outcomeService.create(name, otype, oname, money, oway, time);		
		return result;
		
	}
}
