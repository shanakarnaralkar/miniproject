package com.example.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandleValidationException extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {

			Map<String, Object> objectBody=new LinkedHashMap<String, Object>();
			objectBody.put("Current TimeStamp", new Date());
			objectBody.put("Status",status.value());
		
			List<String> exceptionalError=exception.getBindingResult()
																								.getFieldErrors()
																								.stream()
																								.map(x -> x.getDefaultMessage())
																								.collect(Collectors.toList());
			
			objectBody.putIfAbsent("Errors", exceptionalError);
		
		return new ResponseEntity<Object>(objectBody, status);
	}
	
}
