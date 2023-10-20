package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.User;
import com.example.service.UserService;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/password-request")
	public String passwordRequest()
	{
		return "password-request";
	}
	
	@PostMapping("/password-request")
	public String savePasswordRequest(@RequestParam("email") String email,Model model)
	{
		
		User user = userService.findByEmail(email);
		
		if(user==null)
		{
			model.addAttribute("error", "email is not registered");
			return "password-request";
		}
		
		return "password-request";
	}
	
	@GetMapping("/reset-password")
	public String resetPassword()
	{
		return "reset-password";
	}
	
	@PostMapping("/reset-password")
	public String saveResetPassword()
	{
		return "reset-password";
	}

}
