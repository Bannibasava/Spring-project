package com.rca.OneToMany.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rca.OneToMany.entities.Category;
import com.rca.OneToMany.service.CategoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
	
	private final CategoryService service;
	
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return service.createCategory(category);
	}

}
