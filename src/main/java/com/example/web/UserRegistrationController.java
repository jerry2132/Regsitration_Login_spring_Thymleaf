package com.example.web;

import jakarta.validation.Valid;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.User;
import com.example.service.UserService;
import com.example.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

	@Autowired
	private UserDetailsService userDetailsService;

	private UserService userService;

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}

	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}

//	@GetMapping("/home")
//	public String home(Model model, Principal principal) {
//		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
//		model.addAttribute("userdetail", userDetails);
//		return "home";
//	}

	@GetMapping
	public String showRegistrationForm() {
		
		return "registration";
	}

//	@GetMapping("/login")
//	public String loign(Model model, UserRegistrationDto userRegistrationDto) {
//		model.addAttribute("user", userRegistrationDto);
//		return "login";
//	}

	@PostMapping
	public String RegisterUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userRegistrationDto,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "registration";
		}
		
		User user = userService.findByEmail(userRegistrationDto.getEmail());
		if(user != null)
		{
			model.addAttribute("userexist", user);
			return "registration";
		}

		userService.save(userRegistrationDto);

		return "redirect:/registration?success";
	}

}
