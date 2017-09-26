package com.ffms.dao;

import org.apache.ibatis.annotations.Param;

public interface IOcomeDao {
	public int findincome();
	public int findoutcome();
	public int bytimeincome(@Param("starttime")String startintime,@Param("endtime")String endintime);
	public int bytimeoutcome(@Param("starttime")String startouttime,@Param("endtime")String endouttime);
}
