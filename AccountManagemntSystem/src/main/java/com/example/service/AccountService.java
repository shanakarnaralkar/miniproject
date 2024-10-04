package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.entity.Customer;
import com.example.repository.AccountRepository;
import com.example.repository.CustomerRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accRepo;
	
	@Autowired
	private CustomerRepository custRepo;
	
	public Account createAccount(Integer id, Account account) {
		Customer customer = custRepo.findById(id).get();
		 account.setCustomer(customer);
		return accRepo.save(account);
	}
	
	public List<String> getAllAccounts(){
		List<Account> accounts = accRepo.findAll();
		
		/*
		 * return accounts.stream().map( account -> { String accountInfo=
		 * "Account Number :"+account.getAccountNo() +" Transactions [" ; String
		 * transactions= account.getTransactions().stream().map( txn ->
		 * txn.getAmount()+" "+txn.getType()+" "+txn.getDate()).collect(Collectors.
		 * joining(", ")); return accountInfo + transactions + "]" ;
		 * }).collect(Collectors.toList());
		 */
		
	         	return accounts.stream().flatMap( acc -> {
	         		String accInfo= "Account Number : "+ acc.getAccountNo() +" Transactions : [" ;
	         		return acc.getTransactions().stream().map( txns -> accInfo + txns.getAmount() +",  "+ txns.getType()+",  "+txns.getDate() + "]"  );
	         	}).collect(Collectors.toList());
	}
	
	public void deleteAccount(Integer id) {
		accRepo.deleteById(id);
	}
	
}
