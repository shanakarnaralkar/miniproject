package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.controller.ProductController;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@WebMvcTest(value = ProductController.class)
public class ProductServiceTest {

	@MockBean
	private ProductService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	public void saveProduct() {
			
	Product product=new Product(2,"TV","32 inch", 10000.00);
		
	when(service.addProduct(Mockito.any(Product.class) )).thenReturn("product added");
	
	               String product2 = service.addProduct(product);
	               
	               assertEquals(1,product2);
	
	
	}
	
}
