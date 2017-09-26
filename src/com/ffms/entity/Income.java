package com.ffms.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 收入情况
 * @author 李维俊
 *
 */
public class Income {
	private Integer iid;//收入id
	private String name;//成员姓名
	private String itype;//收入类型
	private String iname;//收入名
	private String money;//金额
	private String iway;//收入方式
	private String time;//收入时间
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
//	public String getTime() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		return sdf.format(time);
//	}
//	public void setTime(String date2) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = null;
//		try {
//			date = sdf.parse(date2);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		this.time = date;
//	}
	public Integer getIid() {
		return iid;
	}
	public void setIid(Integer iid) {
		this.iid = iid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getItype() {
		return itype;
	}
	public void setItype(String itype) {
		this.itype = itype;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getIway() {
		return iway;
	}
	public void setIway(String iway) {
		this.iway = iway;
	}
	
	
}
