package com.ffms.contorller.outcome;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.OutcomeService;

@Controller
@RequestMapping("/outcome")
public class OutcomeUpdateController {
	
	@Autowired
	private OutcomeService outcomeService;
	
	@RequestMapping("/updateoutcome")
	@ResponseBody
	public FfmsResult execute(int oid,String name,String otype,String oname,String money,String oway,String time){
		FfmsResult result = outcomeService.update(oid, name, otype, oname, money, oway, time);
		return result;
		
	}
}
