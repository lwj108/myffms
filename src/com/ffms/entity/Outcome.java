package com.ffms.entity;

import java.util.Date;

/**
 * 支出情况
 * @author 李维俊
 *
 */
public class Outcome {
	private Integer oid;//支出id
	private String name;//成员姓名
	private String otype;//支出类型
	private String oname;//支出名
	private String money;//金额
	private String oway;//支出方式
	private String time;//支出时间
	
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOtype() {
		return otype;
	}
	public void setOtype(String otype) {
		this.otype = otype;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getOway() {
		return oway;
	}
	public void setOway(String oway) {
		this.oway = oway;
	}
	
}
