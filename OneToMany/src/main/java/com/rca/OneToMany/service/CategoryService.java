package com.rca.OneToMany.service;

import org.springframework.stereotype.Service;

import com.rca.OneToMany.entities.Category;
import com.rca.OneToMany.repo.CategoryRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryService {
	
	private final CategoryRepo repo;
	
	public Category createCategory(Category category) {
		return repo.save(category);
	}

}
