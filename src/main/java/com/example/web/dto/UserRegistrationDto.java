package com.example.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class UserRegistrationDto {
	
	@NotEmpty(message ="first name is required")
	private String firstName;
	
	@NotEmpty(message ="last name is required")
	private String lastName;
	
	@NotEmpty(message ="Email is required")
	@Email(message = "Invalid email format")
	private String email;
	
	@NotEmpty(message ="password is required")
	private String password;
	
	public UserRegistrationDto()
	{
		
	}
	
	public UserRegistrationDto(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
