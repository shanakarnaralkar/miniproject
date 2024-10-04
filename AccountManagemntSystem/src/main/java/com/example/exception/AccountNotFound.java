package com.example.exception;

public class AccountNotFound extends RuntimeException{

	
	public AccountNotFound() {
		// TODO Auto-generated constructor stub
	}
	
	public AccountNotFound(String msg) {
		super(msg);
	}
}
