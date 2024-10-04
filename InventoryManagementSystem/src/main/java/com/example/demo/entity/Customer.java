package com.example.demo.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custId;
	
	@NotEmpty(message = "Customer Name should not be empty")
	private String custName;
	
	@Min(value = 6, message ="Phone No should not be less than 0" )
	private Integer phoneNo;
	
	@NotEmpty(message = "Address  should not be empty")
	private String address;

	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
	private List<Order> order;
	
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}


	public Customer(Integer custId, @NotEmpty(message = "Customer Name should not be empty") String custName,
			@Min(value = 0, message = "Phone No should not be less than 0") Integer phoneNo,
			@NotEmpty(message = "Address  should not be empty") String address, List<Order> order) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.phoneNo = phoneNo;
		this.address = address;
		this.order = order;
	}


	public Integer getCustId() {
		return custId;
	}


	public void setCustId(Integer custId) {
		this.custId = custId;
	}


	public String getCustName() {
		return custName;
	}


	public void setCustName(String custName) {
		this.custName = custName;
	}


	public Integer getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(Integer phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<Order> getOrder() {
		return order;
	}


	public void setOrder(List<Order> order) {
		this.order = order;
	}


	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName + ", phoneNo=" + phoneNo + ", address=" + address
				+ ", order=" + order + "]";
	}
	
	
	
	
}
