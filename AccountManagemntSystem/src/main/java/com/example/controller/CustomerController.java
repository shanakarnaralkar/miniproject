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

import com.example.entity.Customer;
import com.example.service.CustomerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService custService;
	
	@PostMapping("/add")
	public Customer createCustomer(@Valid @RequestBody Customer customer) {
		return custService.addCustomer(customer);
	}
	
	@GetMapping("/get")
	public List<String> getAllCustomer(){
		return custService.getAllCustomer();
	}
	
	@GetMapping("/getAll/{id}")
	public Customer getCustomerById(@PathVariable Integer id) {
		return custService.getCustomerById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCustomer(@PathVariable Integer id) {
		custService.deleteCustomer(id);
	}
	
}
