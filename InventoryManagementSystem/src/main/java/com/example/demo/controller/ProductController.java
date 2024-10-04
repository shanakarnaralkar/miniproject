package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product/api")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/add")
	 public ResponseEntity<String> addProduct(@Valid @RequestBody Product prodcut){		 
		 String msg = service.addProduct(prodcut);
		 return new ResponseEntity<String>(msg,HttpStatus.CREATED); 
	 }
	
	@GetMapping("/fetch")
	public ResponseEntity<List<Product>> getAllProduct(){
		 List<Product> produt = service.getAllProdut();
		 return new ResponseEntity<List<Product>>(produt,HttpStatus.OK);
	}
 	
	@GetMapping("/fetchProductById/{id}")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable(value = "id") Integer id){
		Optional<Product> byId = service.getProdutById(id);
		return new ResponseEntity<Optional<Product>>(byId,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PutMapping("/updateProduct")
	public ResponseEntity<String> updateProduct(@Valid	@RequestBody Product product){
		String msg = service.updateProduct(product);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteProductById(@PathVariable(value = "id") Integer id){
		String msg = service.deleteProductById(id);
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	
}
