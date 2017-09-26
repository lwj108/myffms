package com.ffms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffms.dao.OutcomeDao;
import com.ffms.entity.FfmsResult;
import com.ffms.entity.Outcome;
import com.ffms.service.OutcomeService;
@Service
@Transactional
public class OutcomeServiceImpl implements OutcomeService{

	@Autowired
	private OutcomeDao outcomeDao;
	
	/**
	 * 加载支出
	 */
	public FfmsResult loadOutcome() {
		FfmsResult result = new FfmsResult();
		List<Outcome> list = outcomeDao.findAll();
		
		result.setData(list);
		result.setStatus(0);
		result.setMsg("加载支出成功");
		return result;
	}

	/**
	 * 删除支出
	 */
	public FfmsResult deleteOutcome(int oid) {
		FfmsResult result = new FfmsResult();
		outcomeDao.delete(oid);
		result.setStatus(0);
		result.setMsg("删除支出成功");
		return result;
	}

	/**
	 * 修改支出
	 */
	public FfmsResult update(int oid,String name, String otype, String oname,
			String money, String oway, String time) {
		FfmsResult result = new FfmsResult();
		Outcome outcome = new Outcome();
		outcome.setOid(oid);
		outcome.setName(name);
		outcome.setOtype(otype);
		outcome.setOname(oname);
		outcome.setMoney(money);
		outcome.setOway(oway);
		outcome.setTime(time);
		outcomeDao.update(outcome);
		result.setStatus(0);
		result.setMsg("修改支出成功");
		result.setData(outcome);
		return result;
	}

	/**
	 * 添加支出
	 */
	public FfmsResult create(String name, String otype, String oname,
			String money, String oway, String time) {
		FfmsResult result = new FfmsResult();
		Outcome outcome = new Outcome();
		outcome.setName(name);
		outcome.setOtype(otype);
		outcome.setOname(oname);
		outcome.setMoney(money);
		outcome.setOway(oway);
		outcome.setTime(time);
		outcomeDao.add(outcome);
		result.setStatus(0);
		result.setData("创建支出成功");
		result.setData(name);
		return result;
	}

	/**
	 * 合计支出
	 */
	public FfmsResult sum() {
		FfmsResult result = new FfmsResult();
		 
		result.setStatus(0);
		result.setMsg("合计金额");
		result.setData(outcomeDao.sum());
		return result;
	}

	/**
	 * 按成员名查询
	 */
	public FfmsResult findbyname(String name) {
		FfmsResult result = new FfmsResult();
		List<Outcome> list = outcomeDao.findbyname(name);
		if (list.size() > 0) {
			result.setStatus(0);
			result.setMsg("查询到结果");
			result.setData(list);
		} else {
			result.setStatus(1);
			result.setMsg("未查询到结果");
		}
		
		return result;
	}

	/**
	 * 按时间查询
	 */
	public FfmsResult findbytime(String starttime, String endtime) {
		FfmsResult result = new FfmsResult();
		List<Outcome> list = outcomeDao.findbytime(starttime, endtime);
		System.out.println(1);
		if (list.size() > 0) {
			result.setStatus(0);
			result.setMsg("查询到结果");
			result.setData(list);
		} else {
			result.setStatus(1);
			result.setMsg("未查询到结果");
		}
		return result;
	}

	/**
	 * 根据成员名合计金额
	 */
	public FfmsResult sumbyname(String name) {
		FfmsResult result = new FfmsResult();

		result.setStatus(0);
		result.setMsg("根据成员合计金额");
		result.setData(outcomeDao.sumbyname(name));
		return result;
	}

	/**
	 * 根据时间合计金额
	 */
	public FfmsResult sumbytime(String starttime, String endtime) {
		FfmsResult result = new FfmsResult();

		result.setStatus(0);
		result.setMsg("根据时间合计金额");
		result.setData(outcomeDao.sumbytime(starttime,endtime));
		return result;
	}

	/**
	 * 根据类型查询
	 */
	public FfmsResult findbytype(String otype) {
		FfmsResult result = new FfmsResult();
		List<Outcome> list = outcomeDao.findbytype(otype);
		if (list.size() > 0) {
			result.setStatus(0);
			result.setMsg("查询到结果");
			result.setData(list);
		} else {
			result.setStatus(1);
			result.setMsg("未查询到结果");
		}
		
		return result;
	}

	/**
	 * 根据类型合计金额
	 */
	public FfmsResult sumbytype(String otype) {
		FfmsResult result = new FfmsResult();

		result.setStatus(0);
		result.setMsg("根据成员合计金额");
		result.setData(outcomeDao.sumbytype(otype));
		return result;
	}

}
