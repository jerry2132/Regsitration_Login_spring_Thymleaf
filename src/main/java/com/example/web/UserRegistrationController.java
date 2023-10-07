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
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }
	
	@GetMapping("/home")
	public String home()
	{
		return "home";
	}
	
	@GetMapping("/registration")
	public String showRegistrationForm()
	{
		return "registration";
	}
	
	@GetMapping("/login")
	public String loign()
	{
		return "login";
	}
	
	
	@PostMapping
	public String RegisterUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto, BindingResult bindingResult)
	{
		
	 
		if (bindingResult.hasErrors()) {
	        return "registration";
	    }
		
		
		userService.save(userRegistrationDto);
		
		return "redirect:/registration?success";
	}

}
