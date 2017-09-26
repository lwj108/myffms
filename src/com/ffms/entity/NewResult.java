package com.ffms.entity;

public class NewResult {
	private int status;//状态,0正常
	private String msg;//消息
	private Object startdata;
	private Object endtdata;//数据
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getStartdata() {
		return startdata;
	}
	public void setStartdata(Object startdata) {
		this.startdata = startdata;
	}
	public Object getEndtdata() {
		return endtdata;
	}
	public void setEndtdata(Object endtdata) {
		this.endtdata = endtdata;
	}
	
	
}