package com.example.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Account Number is mandatory")
	//@Size(min = 12, max = 12,message = "Account Number must be 12 degit")
	private String accountNo;
	
	@NotNull(message = "Account balance cannot be null")
	@DecimalMin(value = "0.0",inclusive = false,message = "Account Number must be possitive")
	private Double balance;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	@JsonIgnore
	private Customer customer;
	
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Transaction> transactions;

	public Account() {
		// TODO Auto-generated constructor stub
	}
	
	public Account(Integer id, String accountNo, Double balance, Customer customer, List<Transaction> transactions) {
		super();
		this.id = id;
		this.accountNo = accountNo;
		this.balance = balance;
		this.customer = customer;
		this.transactions = transactions;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id ) {
		this.id = id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [customerId =" + id + ", accountNo=" + accountNo + ", balance=" + balance + ", customer=" + customer
				+ ", transactions=" + transactions + "]";
	}
	
	
	
	
}
