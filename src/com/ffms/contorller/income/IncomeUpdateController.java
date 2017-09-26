package com.ffms.contorller.income;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.IncomeService;
@Controller
@RequestMapping("/income")
public class IncomeUpdateController {
	
	@Autowired
	private IncomeService incomeService;
	
	@RequestMapping("/updateincome")
	@ResponseBody
	public FfmsResult execute(int iid,String name,String itype,String iname,String money,String iway,String time){
		FfmsResult result = incomeService.update(iid, name, itype, iname, money, iway, time);
		return result;
		
	}
}
