package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer prodId;
	
	@NotEmpty(message = "Product should not be empty")
	private String prodName;
	
	@NotEmpty(message = "Description  should not be empty")
	private String description;
	
	@DecimalMin(value = "0.01",message = "Price should be greater than 0")
	private Double price;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(Integer prodId, @NotEmpty(message = "Product should not be empty") String prodName,
			@NotEmpty(message = "Description  should not be empty") String description,
			@DecimalMin(value = "0.01", message = "Price should be greater than 0") Double price) {
		super();
		this.prodId = prodId;
		this.prodName = prodName;
		this.description = description;
		this.price = price;
	}

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [prodId=" + prodId + ", prodName=" + prodName + ", description=" + description + ", price="
				+ price + "]";
	}
	
	
	
	
}
