package com.example.demo.exception;

public class CustomerNotFound extends RuntimeException {

	public CustomerNotFound() {
		// TODO Auto-generated constructor stub
	}
	
	public CustomerNotFound(String msg) {
		super(msg);
	}
}
