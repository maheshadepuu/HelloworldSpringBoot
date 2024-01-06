package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.User;
import com.project.repository.UserJpaRepository;
import com.project.repository.UserRepository;
@Service
public class UserJpaService implements UserRepository
{
	@Autowired
	private UserJpaRepository userJpaRepository;

	@Override
	public User addUser(User user) {
		 userJpaRepository.save(user);
		 return user;

		
	}
}

