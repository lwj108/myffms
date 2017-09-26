package com.ffms.service;

import com.ffms.entity.FfmsResult;

public interface IncomeService {
	public FfmsResult loadIncome();
	public FfmsResult deleteIncome(int iid);
	public FfmsResult update(int iid,String name,String itype,String iname,String money,String iway,String time);
	public FfmsResult create(String name,String itype,String iname,String money,String iway,String time);
	public FfmsResult loadtable();
	public FfmsResult sum();
	public FfmsResult findbyname(String name);
	public FfmsResult findbytime(String starttime,String endtime);
	public FfmsResult findbytype(String itype);
	public FfmsResult sumbyname(String name);
	public FfmsResult sumbytime(String starttime,String endtime);
	public FfmsResult sumbytype(String itype);
	
//	PagedResult<Income> queryByPage(Integer pageNo,Integer pageSize);
	
}
