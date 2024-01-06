package com.project.repository;

import java.util.ArrayList;

import com.project.model.Category;


public interface CategoryRepository 
{
	ArrayList<Category> getCategory();
	Category getCategoryById(long categoryId);
	Category addCategory(Category category);
	Category updateCategory(long categoryId, Category category);
	void deleteCategory(long categoryId);
	//public Category postcategory(Category category);
}

