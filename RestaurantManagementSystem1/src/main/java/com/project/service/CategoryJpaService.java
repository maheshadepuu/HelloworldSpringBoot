package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.project.model.Category;
import com.project.repository.CategoryJpaRepository;
import com.project.repository.CategoryRepository;



@Service
public class CategoryJpaService implements CategoryRepository
{
	@Autowired
     public CategoryJpaRepository categoryJpaRepository;
	@Override
	public ArrayList<Category> getCategory() {

		List<Category> categoryList=categoryJpaRepository.findAll();
		ArrayList<Category> categories=new ArrayList<>(categoryList);
		return categories;
	}

	@Override
	public Category getCategoryById(long categoryId) {
		try
		{
			Category category= categoryJpaRepository.findById(categoryId).get();
		return category;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Category addCategory(Category category) {
		categoryJpaRepository.save(category);
		 return category;
	}

	@Override
	public Category updateCategory(long categoryId, Category category) {
		try
		{
		Category existingCategory= categoryJpaRepository.findById(categoryId).get();
		if(category.getName()!=null)
		{
			existingCategory.setName(category.getName());
		}
		if(category.getDescription()!=null)
		{
			existingCategory.setDescription(category.getDescription());
		}
		categoryJpaRepository.save(existingCategory);
		return existingCategory;
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteCategory(long categoryId) {
		try
		{
		Category category= categoryJpaRepository.findById(categoryId).get();
		if(category!=null)
		{
			categoryJpaRepository.deleteById(categoryId);
		}
		}
		catch(Exception e)
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		
	}
   
	}
}
