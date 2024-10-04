package com.example.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.entity.Transaction;
import com.example.exception.AccountNotFound;
import com.example.exception.InsufficientBalance;
import com.example.repository.AccountRepository;
import com.example.repository.TransactionRepository;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository trnRepo;
	
	@Autowired
	private AccountRepository accRepo;
	
	@Transactional
	public Transaction deposit(Integer accountId, Double amount) {
		Account account= accRepo.findById(accountId).orElseThrow(() -> new AccountNotFound("Account not found with this id "+accountId+" please try agian"));
      
		account.setBalance(account.getBalance() +  amount);
		accRepo.save(account);
		
		Transaction transaction=new Transaction();
		transaction.setAccount(account);
		transaction.setAmount(amount);
		transaction.setDate(new Date());
		transaction.setType("DEPOSIT");
	
	   return	trnRepo.save(transaction);
	}
	
	@Transactional
	public Transaction withdraw(Integer accountId, Double amount) {
		
		Account account=accRepo.findById(accountId).orElseThrow(() -> new AccountNotFound("Account not found with this id "+accountId+" please try agian"));
		
		if(account.getBalance() < amount) {
			 throw  new InsufficientBalance("The money in your account is not enough for this transaction Check account and try agian.");
		}
		
		account.setBalance(account.getBalance() - amount);
		accRepo.save(account);
		
		Transaction transaction=new Transaction();
		transaction.setAccount(account);
		transaction.setAmount(amount);
		transaction.setDate(new Date());
		transaction.setType("WITHDRAWAL");
		
		return trnRepo.save(transaction);
		
	}
	
	
	
}
