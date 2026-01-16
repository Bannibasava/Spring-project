package com.rca.OneToMany.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rca.OneToMany.entities.Product;
import com.rca.OneToMany.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
	
private final ProductService service;
	
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return service.createProduct(product);
	}

}


