package com.example.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.web.dto.UserRegistrationDto;

@Service
public interface UserService extends UserDetailsService{

	User save(UserRegistrationDto registrationDto);
	
}
