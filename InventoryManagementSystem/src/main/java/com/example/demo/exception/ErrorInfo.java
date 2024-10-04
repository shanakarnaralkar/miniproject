package com.example.demo.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorInfo {

	private String msg;
	private LocalDateTime date;
	private String status;
	
	public ErrorInfo() {
		// TODO Auto-generated constructor stub
	}

	public ErrorInfo(String msg, LocalDateTime date, String status) {
		super();
		this.msg = msg;
		this.date = date;
		this.status = status;
	}
	
	
	
}
