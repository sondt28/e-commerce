package com.son.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.son.ecommerce.dto.LoginDto;
import com.son.ecommerce.dto.RegisterDto;
import com.son.ecommerce.service.AuthService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
	private AuthService service;
	
	@PostMapping("/login")
	public Object login(@RequestBody LoginDto dto) {
		
		String token = service.login(dto);
		
		if (token == null) {
			return new ResponseEntity<>("Password is not correct !", 
										HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(token, HttpStatus.CREATED);
	}
	
	@PostMapping("/register")
	public Object register(@RequestBody RegisterDto dto) {
		
		service.register(dto);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
