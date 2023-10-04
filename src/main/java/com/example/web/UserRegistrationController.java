package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.UserService;
import com.example.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	private UserService userService;

	
	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto()
	{
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showResitrationForm()
	{
		return "registration";
	}
	
	
	@PostMapping
	public String RegisterUserAccount(@ModelAttribute("user") UserRegistrationDto userRegistrationDto)
	{
		userService.save(userRegistrationDto);
		return "redirect:/registration?success";
	}

}
