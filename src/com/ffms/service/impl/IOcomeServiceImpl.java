package com.ffms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffms.dao.IOcomeDao;
import com.ffms.entity.FfmsResult;
import com.ffms.entity.IOcome;
import com.ffms.service.IOcomeService;
@Service
@Transactional
public class IOcomeServiceImpl implements IOcomeService{

	@Autowired
	private IOcomeDao iocomeDao;
	/**
	 * 合计收入支出金额
	 */
	public FfmsResult findincome() {
		FfmsResult result = new FfmsResult();
		result.setStatus(0);
		result.setMsg("合计收入金额");
		result.setData(iocomeDao.findincome());
		return result;
	}

	public FfmsResult findoutcome() {
		FfmsResult result = new FfmsResult();
		result.setStatus(0);
		result.setMsg("合计支出金额");
		result.setData(iocomeDao.findoutcome());
		return result;
	}

//	public FfmsResult findbytimeincome(String starttime,String endtime) {
//		FfmsResult result = new FfmsResult();
//		result.setStatus(0);
//		result.setMsg("根据时间合计收入金额");
//		result.setData(iocomeDao.bytimeincome(starttime, endtime));
//		return result;
//	}
//
//	public FfmsResult findbytimeoutcome(String starttime,String endtime) {
//		FfmsResult result = new FfmsResult();
//		result.setStatus(0);
//		result.setMsg("根据时间合计支出金额");
//		result.setData(iocomeDao.bytimeoutcome(starttime, endtime));
//		return result;
//	}

}
