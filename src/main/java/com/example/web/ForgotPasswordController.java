package com.example.web;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.ForgotPasswordToken;
import com.example.model.User;
import com.example.service.ForgotPasswordService;
import com.example.service.UserService;

import jakarta.mail.MessagingException;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ForgotPasswordService forgotPasswordService;
	
	@GetMapping("/password-request")
	public String passwordRequest()
	{
		return "password-request";
	}
	
	@PostMapping("/password-request")
	public String savePasswordRequest(@RequestParam("email") String email, Model model)
	{
		
		User user = userService.findByEmail(email);
		
		if(user==null)
		{
			model.addAttribute("error", "email is not registered");
			return "password-request";
		}
		
		ForgotPasswordToken forgotPasswordToken = new ForgotPasswordToken();
		forgotPasswordToken.setExpireTime(forgotPasswordService.expireTimeRange());
		forgotPasswordToken.setToken(forgotPasswordService.generateToken());
		forgotPasswordToken.setUser(user);
		forgotPasswordToken.setUsed(false);
		
		String emailLink = "http:localhost:8080/reset-password?token= " + forgotPasswordToken.getToken();
		
		try {
			forgotPasswordService.sendMail(user.getEmail(), "Password Reset Link", emailLink);
		} catch (UnsupportedEncodingException | MessagingException e) {
			
			model.addAttribute("error", "Error while sending email");
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "password-request";
		}  
		
		return "redirect:/password-request?success";
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
