package com.example.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerClass {

	
	@ExceptionHandler(InsufficientBalance.class)
	public ResponseEntity<ErrorInfo> insufficientBalanceException(InsufficientBalance isb){
		ErrorInfo info=new ErrorInfo(isb.getMessage(), new Date(), "500");
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(AccountNotFound.class)
	public ResponseEntity<ErrorInfo> accoountNotFound(AccountNotFound anf){
		ErrorInfo info=new ErrorInfo(anf.getMessage(), new Date(), "500");
		return new ResponseEntity<ErrorInfo>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
