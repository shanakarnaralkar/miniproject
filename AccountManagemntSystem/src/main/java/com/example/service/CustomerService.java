package com.example.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Customer;
import com.example.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository custRepo;
	
	public Customer addCustomer(Customer customer) {
		return custRepo.save(customer);
	}
	
	public List<String> getAllCustomer(){
		        List<Customer> customer = custRepo.findAll();
		
		        return customer.stream().map( customers-> {
		        	String customerInfo= " Customer  :"+customers.getName() +", Address : ["  ;
		           String addresses=customers.getAccount().stream().map( account -> account.getAccountNo()+" "+account.getBalance()).collect(Collectors.joining(", "));
		           return customerInfo + addresses + "]" ;
		        }).collect(Collectors.toList());
		        
		
	}
	
	public Customer getCustomerById(Integer id) {
		return custRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id "+ id));
	}
	
	public void deleteCustomer(Integer id) {
		custRepo.deleteById(id);
	}
	
}
