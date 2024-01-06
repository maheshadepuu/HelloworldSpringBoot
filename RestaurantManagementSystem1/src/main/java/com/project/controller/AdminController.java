package com.project.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Category;
import com.project.service.AdminService;



@RestController
@RequestMapping("api/admin")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	@PostMapping("/category")
	public ResponseEntity<Category> postCategory(@RequestBody Category category) throws IOException
	{
		Category createdCategory=adminService.postcategory(category);
		if(createdCategory==null) return ResponseEntity.notFound().build();
		return ResponseEntity.ok(createdCategory);
		
	}
}

