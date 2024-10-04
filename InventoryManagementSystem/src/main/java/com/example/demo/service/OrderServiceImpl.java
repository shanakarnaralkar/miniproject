package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Order;
import com.example.demo.exception.CustomerNotFound;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	@Override
	public String byOrder(Integer id, Order order) {
		
		return custRepo.findById(id).map( cust -> {
			order.setCustomer(cust);
			orderRepo.save(order);
			return "order confirmed";
		}).orElseThrow(() -> new CustomerNotFound("Customer Not Found"));
		
		
		
		
		
	}

}
