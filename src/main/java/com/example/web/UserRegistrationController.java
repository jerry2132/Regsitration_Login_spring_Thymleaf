package com.example.web;

import jakarta.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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
	public String showRegistrationForm()
	{
		return "registration";
	}
	
	
	@PostMapping
	public String RegisterUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto, BindingResult bindingResult)
	{
		
	 
		if (bindingResult.hasErrors()) {
	        // Handle validation errors, e.g., return to the registration form with error messages
			 System.out.println("Validation failed. Returning to registration form.");
	        return "registration";
	    }
		
		 System.out.println("Validation passed. Proceeding with user registration logic.");
		
		userService.save(userRegistrationDto);
		
		return "redirect:/registration?success";
	}

}
