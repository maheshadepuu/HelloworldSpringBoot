package com.project.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.User;
import com.project.service.UserJpaService;
@RestController
public class UserController 
{
	@Autowired
	private UserJpaService  userService;

	@PostMapping("/users/addnewUser")
	public User addMobile(@RequestBody User user) 
	{
		 return userService.addUser(user);

	  
    }
}
