package com.example.web;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	@GetMapping("/")
	public String home(Model model, Principal principal) {
		
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("userdetail", userDetails);
		return "home";
	}
	

}
