package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerClass {

	@ExceptionHandler(ProductNotFound.class)
	public ResponseEntity<ErrorInfo> handleProductNotFoundExceptio(ProductNotFound pnf){
		ErrorInfo error=new ErrorInfo(pnf.getMessage(), LocalDateTime.now(), "500");
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CustomerNotFound.class)
	public ResponseEntity<ErrorInfo> handleCustomerNotFoundException(CustomerNotFound cnf){
		ErrorInfo error=new ErrorInfo(cnf.getMessage(),LocalDateTime.now(),"500");
		return new ResponseEntity<ErrorInfo>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
