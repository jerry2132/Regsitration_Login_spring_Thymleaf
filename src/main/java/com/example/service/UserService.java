package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.web.dto.UserRegistrationDto;


public interface UserService {

	User save(UserRegistrationDto registrationDto);
	
}
