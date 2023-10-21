package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import java.util.Collection;
import org.springframework.stereotype.Service;

//import org.springframework.security.core.userdetails.UserDetails;
import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.web.dto.UserRegistrationDto;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	PasswordEncoder passwordEncoder;
	
	private UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@Override
	public User save(UserRegistrationDto registrationDto) {
	
		User user = new User(registrationDto.getFirstName(), 
				registrationDto.getLastName(), registrationDto.getEmail(),
				passwordEncoder.encode(registrationDto.getPassword()));
		
		return userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(email);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
		
	}
	
	

}
