package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.aspectj.apache.bcel.ExceptionConstants;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "productorder")
public class Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	@NotNull(message = "Date should not be null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate orderedDate;
	
	@NotNull(message = "Date should not be null")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate deliveryDate;
	
	@NotEmpty(message = "Status should not be empty")
	private String status;
	
	@NotEmpty(message = "Product should not be empty")
	private String product;
	
	@NotNull(message = "Quantity should not be null")
	@Min(value = 0,message = "Quantity should greater than 0")
	private Integer quantity;
	
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	
	public Order() {
		// TODO Auto-generated constructor stub
	}


	public Order(Integer orderId, @NotNull(message = "Date should not be null") LocalDate orderedDate,
			@NotNull(message = "Date should not be null") LocalDate deliveryDate,
			@NotEmpty(message = "Status should not be empty") String status,
			@NotEmpty(message = "Product should not be empty") String product,
			@NotNull(message = "Quantity should not be null") @Min(value = 0, message = "Quantity should greater than 0") Integer quantity,
			Customer customer) {
		super();
		this.orderId = orderId;
		this.orderedDate = orderedDate;
		this.deliveryDate = deliveryDate;
		this.status = status;
		this.product = product;
		this.quantity = quantity;
		this.customer = customer;
	}


	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}


	public LocalDate getOrderedDate() {
		return orderedDate;
	}


	public void setOrderedDate(LocalDate orderedDate) {
		this.orderedDate = orderedDate;
	}


	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}


	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getProduct() {
		return product;
	}


	public void setProduct(String product) {
		this.product = product;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderedDate=" + orderedDate + ", deliveryDate=" + deliveryDate
				+ ", status=" + status + ", product=" + product + ", quantity=" + quantity + ", customer=" + customer
				+ "]";
	}
	
	
	
	
	
	
}
