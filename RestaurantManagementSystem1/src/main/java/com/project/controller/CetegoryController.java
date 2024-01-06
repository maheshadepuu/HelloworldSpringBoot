package com.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Category;
import com.project.service.CategoryJpaService;



@RestController
public class CetegoryController {
	@Autowired
	private CategoryJpaService categoryService;
	@GetMapping("/categories")
	public ArrayList<Category> getCategoryt() {
		 return categoryService.getCategory();
	}
	@GetMapping("/categories/{categoryId}")
	public Category getCategoryById(@PathVariable long categoryId) {
		
		return categoryService.getCategoryById(categoryId);
	}
	@PostMapping("/categories/addnewcategory")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	@PutMapping("/categories/{categoryId}")
	public Category updateCategory(@PathVariable long categoryId,@RequestBody Category category)
	{
		return categoryService.updateCategory(categoryId, category);
	}
	@DeleteMapping("/categories/{categoryId}")
	public void deleteCategory(@PathVariable("categoryId")long categoryId) {
		categoryService.deleteCategory(categoryId);
		
	}
 


}

