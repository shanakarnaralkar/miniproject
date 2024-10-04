package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customer/api")
public class CustomerController {

	@Autowired
	private CustomerService service;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCustomer(@Valid @RequestBody Customer customer){
		String msg = service.addCustomer(customer);
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<Customer>> getAllCustomer(){
		List<Customer> cusotmer = service.getAllCusotmer();
		return new ResponseEntity<List<Customer>>(cusotmer, HttpStatus.OK);
	}
	
	@GetMapping("/getCustomerById/{id}") 
	public ResponseEntity<Optional<Customer>> getCustomerById(@PathVariable(value = "id") Integer id){
		Optional<Customer> customerById = service.getCustomerById(id);
		return new ResponseEntity<Optional<Customer>>(customerById, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCustomer(@Valid @RequestBody Customer cusotmer){
		String msg = service.updateCusotmer(cusotmer);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable(value="id") Integer id){
		String msg = service.deletedCustomerById(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
}
