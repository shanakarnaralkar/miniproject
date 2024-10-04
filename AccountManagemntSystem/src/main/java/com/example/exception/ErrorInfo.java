package com.example.exception;

import java.util.Date;

public class ErrorInfo {
	
	private String msg;
	private Date date;
	private String statusCode;
	
	public ErrorInfo() {
		// TODO Auto-generated constructor stub
	}

	public ErrorInfo(String msg, Date date, String statusCode) {
		super();
		this.msg = msg;
		this.date = date;
		this.statusCode = statusCode;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ErrorInfo [msg=" + msg + ", date=" + date + ", statusCode=" + statusCode + "]";
	}
	
	

}
