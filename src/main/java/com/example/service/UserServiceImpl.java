package com.example.service;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Role;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.web.UserRegistrationController;
import com.example.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

	
	
	@Autowired
	private UserRepository userRepository;
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public User save(UserRegistrationDto registrationDto) {
		// TODO Auto-generated method stub
		
		System.out.println("Inside UserService.save method");
		User user =new User(registrationDto.getFirstName(),registrationDto.getLastName(),registrationDto.getEmail(),
				registrationDto.getPassword(), Arrays.asList(new Role("ROLE_USER")));
		return userRepository.save(user);
		
		
	}

}
