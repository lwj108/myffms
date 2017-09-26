package com.ffms.contorller.iocome;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ffms.entity.FfmsResult;
import com.ffms.service.IOcomeService;

@Controller
@RequestMapping("/iocome")
public class IOcomeController {
	@Autowired
	private IOcomeService iocomeService;
	
	@RequestMapping("/findincome")
	@ResponseBody
	public FfmsResult execute1(){
		FfmsResult result = iocomeService.findincome();
		return result;
	}
	@RequestMapping("/findoutcome")
	@ResponseBody
	public FfmsResult execute2(){
		FfmsResult result = iocomeService.findoutcome();
		return result;
	}
	
//	@RequestMapping("/incomesumbytime")
//	@ResponseBody
//	public FfmsResult execute3(String starttime,String endtime){
//		FfmsResult result = iocomeService.findbytimeincome(starttime, endtime);
//		return result;
//	}
//	
//	@RequestMapping("/outcomesumbytime")
//	@ResponseBody
//	public FfmsResult execute4(String starttime,String endtime){
//		FfmsResult result = iocomeService.findbytimeoutcome(starttime, endtime);
//		return result;
//	}
}
