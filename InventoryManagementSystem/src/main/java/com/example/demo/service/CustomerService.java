package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Customer;

public interface CustomerService {

	public String addCustomer(Customer customer);
	
	public List<Customer> getAllCusotmer();
	
	public Optional<Customer> getCustomerById(Integer id);
	
	public String updateCusotmer(Customer customer);
	
	public String deletedCustomerById(Integer id);
}
