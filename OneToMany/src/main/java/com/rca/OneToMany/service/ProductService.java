package com.rca.OneToMany.service;

import org.springframework.stereotype.Service;

import com.rca.OneToMany.entities.Product;
import com.rca.OneToMany.repo.ProductRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
	
	public final ProductRepo repo;

	public Product createProduct(Product product) {
		return repo.save(product);
	}

}
