package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Transaction;
import com.example.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionalController {

	@Autowired
	private TransactionService trnService;
	
	@PostMapping("/{id}/deposit")
	public Transaction deposit(@PathVariable(name = "id") Integer accountId, @RequestParam Double amount ) {
		return trnService.deposit(accountId, amount);
	}
	
	@PostMapping("/{id}/withdraw")
	public Transaction withDraw(@PathVariable(name = "id") Integer accountId,@RequestParam Double amount) {
		return trnService.withdraw(accountId, amount);
	}
	
	
	
	
}
