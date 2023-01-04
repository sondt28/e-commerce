package com.son.ecommerce.dto;

import javax.validation.constraints.NotBlank;

import com.son.ecommerce.validation.UniqueEmail;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RegisterDto {
	
	@NotBlank(message = "Email must not be blank")
	@UniqueEmail
	private String emailAddress;
	
	@NotBlank(message = "Phone number must not be blank")
	private String phoneNumber;
	
	@NotBlank(message = "Password must not be blank")
	private String password;
}
