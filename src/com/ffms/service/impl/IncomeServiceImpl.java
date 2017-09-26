package com.ffms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ffms.dao.IncomeDao;
import com.ffms.entity.FfmsResult;
import com.ffms.entity.Income;
import com.ffms.service.IncomeService;

@Service
@Transactional
public class IncomeServiceImpl implements IncomeService {

	@Autowired
	private IncomeDao incomeDao;

	/**
	 * 加载收入
	 */
	public FfmsResult loadIncome() {
		FfmsResult result = new FfmsResult();
		List<Income> list = incomeDao.findAll();
		
//		PageHelper.startPage(PaginationContext.getPageNum(), PaginationContext.getPageSize());
//        List<Income> list2 = this.IncomeMap.getUserByNoAndEmail(list);
		
		result.setData(list);
		result.setStatus(0);
		result.setMsg("加载收入成功");
		return result;

	}

	/**
	 * 加载收入名和金额
	 */
	public FfmsResult loadtable() {
		FfmsResult result = new FfmsResult();
		List<Income> list = incomeDao.find();
		result.setData(list);
		result.setStatus(0);
		result.setMsg("加载收入名和金额成功");
		return result;
	}

	/**
	 * 删除收入
	 */
	public FfmsResult deleteIncome(int iid) {
		FfmsResult result = new FfmsResult();
		incomeDao.delete(iid);
		result.setStatus(0);
		result.setMsg("删除收入成功");
		return result;
	}

	/**
	 * 修改收入
	 */
	public FfmsResult update(int iid,String name, String itype, String iname,
			String money, String iway, String time) {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
//		Date date = null;
//		try {
//			date = sdf.parse(time);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
		FfmsResult result = new FfmsResult();
		Income income = new Income();
		income.setIid(iid);
		income.setName(name);
		income.setItype(itype);
		income.setIname(iname);
		income.setMoney(money);
		income.setIway(iway);
		income.setTime(time);
		incomeDao.update(income);

		result.setData(income);
		result.setStatus(0);
		result.setMsg("修改收入成功");
		return result;
	}

	/**
	 * 添加收入
	 */
	public FfmsResult create(String name, String itype, String iname,
			String money, String iway, String time) {
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
//		Date date = null ;
//		try {
//			date = sdf.parse(time);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		} 
		FfmsResult result = new FfmsResult();
		Income income = new Income();
		income.setName(name);
		income.setItype(itype);
		income.setIname(iname);
		income.setMoney(money);
		income.setIway(iway);
		income.setTime(time);
		incomeDao.add(income);
		result.setStatus(0);
		result.setData("创建收入成功");
		result.setData(income);
		return result;
	}

	/**
	 * 收入合计
	 */
	public FfmsResult sum() {
		FfmsResult result = new FfmsResult();

		result.setStatus(0);
		result.setMsg("合计金额");
		result.setData(incomeDao.sum());
		return result;
	}

	/**
	 * 按成员名查询
	 */
	public FfmsResult findbyname(String name) {
		FfmsResult result = new FfmsResult();
		List<Income> list = incomeDao.findbyname(name);
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
		result.setData(incomeDao.sumbyname(name));
		return result;
	}

	/**
	 * 按时间查询
	 */
	public FfmsResult findbytime(String starttime,String endtime) {
		FfmsResult result = new FfmsResult();
		List<Income> list = incomeDao.findbytime(starttime, endtime);
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
	 * 根据时间合计金额
	 */
	public FfmsResult sumbytime(String starttime, String endtime) {
		FfmsResult result = new FfmsResult();

		result.setStatus(0);
		result.setMsg("根据时间合计金额");
		result.setData(incomeDao.sumbytime(starttime,endtime));
		return result;
	}

	/**
	 * 根据类型查询
	 */
	public FfmsResult findbytype(String itype) {
		FfmsResult result = new FfmsResult();
		List<Income> list = incomeDao.findbytype(itype);
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
	public FfmsResult sumbytype(String itype) {
		FfmsResult result = new FfmsResult();

		result.setStatus(0);
		result.setMsg("根据类型合计金额");
		result.setData(incomeDao.sumbytype(itype));
		return result;
	}

//	public PagedResult<Income> queryByPage(Integer pageNo, Integer pageSize) {
//		pageNo = pageNo == null?1:pageNo;
//		pageSize = pageSize == null?10:pageSize;
//		
//		PageHelper.startPage(pageNo,pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
//		
//		return BeanUtil.toPagedResult(incomeDao.findAll());
//	}

	

}
