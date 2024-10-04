package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accService;
	
	@PostMapping("/create/{id}/account")
	public Account createAccount(@PathVariable Integer id,@Valid @RequestBody Account account) {
		return accService.createAccount(id,account);
	}
	
	@GetMapping("/getAll")
	public List<String> getAllAccounts(){
	  return	accService.getAllAccounts();
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteAccount(@PathVariable Integer id) {
		accService.deleteAccount(id);
	}
	
	
	
}
