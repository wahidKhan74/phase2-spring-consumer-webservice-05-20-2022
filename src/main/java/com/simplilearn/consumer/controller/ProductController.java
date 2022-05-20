package com.simplilearn.consumer.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.simplilearn.consumer.model.Product;

@RestController
@RequestMapping("/api/consumer")
public class ProductController {
	
	private String apiUrl = "http://localhost:8070/api/products";
	
	@GetMapping("/products")
	public List<Product> getAll() {
		RestTemplate template = new RestTemplate();
		ResponseEntity<List> response =template.getForEntity(apiUrl, List.class );
		return response.getBody();
	}

	@GetMapping("/products/{id}")
	public Product getAll(@PathVariable("id") int id) {
		RestTemplate template = new RestTemplate();
		ResponseEntity<Product> response =template.getForEntity(apiUrl+"/"+id, Product.class );
		return response.getBody();
	}
	
	// TODO : Get product by name
	// TODO : Search products by name
	// TODO : Get product available (true/ false).
	
	@PostMapping("/products")
	public Product addOne(@RequestBody Product product) {
		RestTemplate template = new RestTemplate();
		ResponseEntity<Product> response = template.postForEntity(apiUrl, product, Product.class);
		return response.getBody();
	}	
	
	@PutMapping("/products")
	public String  updateOne(@RequestBody Product product) {
		RestTemplate template = new RestTemplate();
		template.put(apiUrl, product);
		return "Product is updated on consumed webservice";
	}
	
	@DeleteMapping("/products/{id}")
	public String deleteOne(@PathVariable("id") int id) {
		RestTemplate template = new RestTemplate();
		template.delete(apiUrl+"/"+id);
		return "Product is deleted successfully.";
	}
}
