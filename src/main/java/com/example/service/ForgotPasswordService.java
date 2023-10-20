package com.example.service;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class ForgotPasswordService {

	@Autowired
	JavaMailSender javaMailSender;
	
	private final int MINUTES = 10;
	
	public String generateToken()
	{
		return UUID.randomUUID().toString();
	}
	 
	public LocalDateTime expireTimeRange()
	{
		return LocalDateTime.now().plusMinutes(MINUTES);
	}
	
	public void sendMail(String to, String subject, String emailLink) throws MessagingException, UnsupportedEncodingException
	{
		
		MimeMessage message  = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message); 
		
		String emailContent  = "<p>Hello user</p>"+"click the link below to reset password"+"<p><a href=\" " + emailLink + "\"> change my password</a></p>"
				+"<br>"
				+"ignore if not done by you";
		
		helper.setText(emailContent,true);
		helper.setFrom("sumitsinghrawat34@gmail.com", "sumitSR");
		helper.setSubject(subject);
		helper.setTo(to);
		javaMailSender.send(message);
		
		
	}
	
}
