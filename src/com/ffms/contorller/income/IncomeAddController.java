package com.ffms.contorller.income;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.IncomeService;

@Controller
@RequestMapping("/income")
public class IncomeAddController {
	
	@Autowired
	private IncomeService incomeService;
	
	@RequestMapping("/addincome")
	@ResponseBody
	public FfmsResult execute(String name, String itype, String iname,
			String money, String iway, String time) throws ParseException{
		
		FfmsResult result = incomeService.create(name, itype, iname, money, iway, time);		
		return result;
		
	}
}
