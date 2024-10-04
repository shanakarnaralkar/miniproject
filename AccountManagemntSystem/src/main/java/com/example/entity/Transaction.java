package com.example.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "Date should not be null")
	private Date date;
	
	@NotBlank(message = "Type is mandatory")
	private String type;         // "DEPOSIT", "WITHDRAWAL", "TRANSFER"
	
	@NotNull(message = "Amount should not be null")
	@DecimalMin(value = "0.0",inclusive = false,message = "Amount must be possitive")
	private Double amount;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(Integer id, Date date, String type, Double amount, Account account) {
		super();
		this.id = id;
		this.date = date;
		this.type = type;
		this.amount = amount;
		this.account = account;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", date=" + date + ", type=" + type + ", amount=" + amount + ", account="
				+ account + "]";
	}
	
	
	
	
	
	
}
