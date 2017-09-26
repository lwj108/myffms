package com.ffms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ffms.entity.Income;

public interface IncomeDao {
	public List<Income> findAll();
	public int delete(int iid);
	public int update(Income income);
	public int add(Income income);
	public List<Income> find();
	public int sum();
	public List<Income> findbyname(String name);
	public List<Income> findbytime(@Param("starttime")String starttime,@Param("endtime")String endtime);
	public List<Income> findbytype(String itype);
	public int sumbyname(String name);
	public int sumbytime(@Param("starttime")String starttime,@Param("endtime")String endtime);
	public int sumbytype(String itype);
	
//	PageHelper.startPage(1, 10);
//	List<Income> list = Income.selectIf(1);

	
}
