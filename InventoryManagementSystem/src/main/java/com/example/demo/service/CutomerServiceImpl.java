package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.exception.CustomerNotFound;
import com.example.demo.repository.CustomerRepository;

@Service
public class CutomerServiceImpl implements  CustomerService{

	@Autowired
	private CustomerRepository repo;
	
	@Override
	public String addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		 Customer cust = repo.save(customer); 
		 return "Customer added with "+cust.getCustId()+" id";
	}

	@Override
	public List<Customer> getAllCusotmer() {
		return repo.findAll();
	}

	@Override
	public Optional<Customer> getCustomerById(Integer id) {
		Optional<Customer> byId = repo.findById(id);
		if(byId.isPresent()) {
			return byId;
		}else {
			throw new CustomerNotFound("Cusotmer not found");
		}
		
	}

	@Override
	public String updateCusotmer(Customer customer) {
		Optional<Customer>id = repo.findById(customer.getCustId());
			if(id.isPresent()) {
				repo.save(customer);
				return "Customer info updated";
			}else {
				throw new CustomerNotFound("Customer not found");
			}
	}

	@Override
	public String deletedCustomerById(Integer id) {
		Optional<Customer> byId = repo.findById(id);
		if(byId.isPresent()) {
			repo.deleteById(id);
			return "Customer is deleted";
		}else {
			throw new CustomerNotFound("Customer not found exception");
		}
	}

}
