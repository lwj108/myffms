package com.ffms.entity;

import java.util.Date;

/**
 * ֧�����
 * @author ��ά��
 *
 */
public class Outcome {
	private Integer oid;//֧��id
	private String name;//��Ա����
	private String otype;//֧������
	private String oname;//֧����
	private String money;//���
	private String oway;//֧����ʽ
	private String time;//֧��ʱ��
	
	
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
