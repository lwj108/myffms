package com.ffms.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * �������
 * @author ��ά��
 *
 */
public class Income {
	private Integer iid;//����id
	private String name;//��Ա����
	private String itype;//��������
	private String iname;//������
	private String money;//���
	private String iway;//���뷽ʽ
	private String time;//����ʱ��
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
