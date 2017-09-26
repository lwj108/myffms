package com.ffms.service;


import com.ffms.entity.FfmsResult;

public interface OutcomeService {
	public FfmsResult loadOutcome();
	public FfmsResult deleteOutcome(int oid);
	public FfmsResult update(int oid,String name,String otype,String oname,String money,String oway,String time);
	public FfmsResult create(String name,String otype,String oname,String money,String oway,String time);
	public FfmsResult sum();
	public FfmsResult findbyname(String name);
	public FfmsResult findbytime(String starttime,String endtime);
	public FfmsResult findbytype(String otype);
	public FfmsResult sumbyname(String name);
	public FfmsResult sumbytime(String starttime,String endtime);
	public FfmsResult sumbytype(String otype);
}
