package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Product;

public interface ProductService {

	public String addProduct(Product product);
	
	public List<Product> getAllProdut();
	
	public Optional<Product> getProdutById(Integer id);
	
	public String updateProduct(Product product);
	
	public String deleteProductById(Integer id);
}
