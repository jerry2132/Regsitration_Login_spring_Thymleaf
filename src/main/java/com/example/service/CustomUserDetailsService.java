package com.example.service;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	 private final UserRepository userRepository;

	    @Autowired
	    public CustomUserDetailsService(UserRepository userRepository) {
	        this.userRepository = userRepository;
	    }
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		User user = userRepository.findByEmail(email);
		
		if(user==null)
		{
			throw new UsernameNotFoundException("usernaem or password not found");
		}
		return new CustomUserDetails(user.getFirstName(),user.getLastName(),user.getEmail(),user.getPassword(),authorities());
		
	}
	
	public Collection<? extends GrantedAuthority> authorities()
	{
		
		return Arrays.asList(new SimpleGrantedAuthority("USER"));
	}
	

}
