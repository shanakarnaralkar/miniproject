package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/order/api")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@PostMapping("/byOrder/{id}/order")
	public ResponseEntity<String> byOrder(@PathVariable(value = "id") Integer id, @RequestBody Order order){
		String msg = service.byOrder(id, order);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
