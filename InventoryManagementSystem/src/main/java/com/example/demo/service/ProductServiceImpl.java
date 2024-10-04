package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFound;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository repo;
	
	@Override
	public String addProduct(Product product) {
		Product save = repo.save(product);
		return "Prodcut addred successfully with"+save.getProdId()+" id";
	}

	@Override
	public List<Product> getAllProdut() {
		return repo.findAll();
	}
	
	@Override
	public Optional<Product> getProdutById(Integer id) {
		Optional<Product> byId = repo.findById(id);
			if(byId.isPresent()) {
				return byId;
			}else {
				throw new ProductNotFound("Product Id Not Found");
		}       
	}
	
	public String updateProduct(Product product) {
		Optional<Product> productId = repo.findById(product.getProdId());
			if(productId.isPresent()) {
				repo.save(product);
				return "Product updaed";
			}else {
				throw new ProductNotFound("Product Not Found");
			}
	}
	
	@Override
	public String deleteProductById(Integer id) {
		Optional<Product> byId = repo.findById(id);
		
			if(byId.isPresent()) {
				repo.deleteById(id);
				return "Product is deleted";
			}else {
				throw new ProductNotFound("Product id is found");
			}
		
	}
	
	
}
