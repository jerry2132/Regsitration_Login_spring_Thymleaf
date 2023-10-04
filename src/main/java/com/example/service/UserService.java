package com.example.service;

import com.example.model.User;
import com.example.web.dto.UserRegistrationDto;

public interface UserService {

	User save(UserRegistrationDto registrationDto);
	
}
