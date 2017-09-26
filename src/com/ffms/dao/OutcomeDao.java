package com.ffms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ffms.entity.Outcome;

public interface OutcomeDao {
	public List<Outcome> findAll();
	public int delete(int oid);
	public int update(Outcome outcome);
	public int add(Outcome outcome);
	public int sum();
	public List<Outcome> findbyname(String name);
	public List<Outcome> findbytime(@Param("starttime")String starttime,@Param("endtime")String endtime);
	public List<Outcome> findbytype(String otype);
	public int sumbyname(String name);
	public int sumbytime(@Param("starttime")String starttime,@Param("endtime")String endtime);
	public int sumbytype(String otype);
}
