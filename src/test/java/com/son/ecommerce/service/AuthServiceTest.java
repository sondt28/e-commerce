package com.son.ecommerce.service;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.son.ecommerce.dto.RegisterDto;
import com.son.ecommerce.model.SiteUser;
import com.son.ecommerce.repository.SiteUserRepository;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

	@Mock
	private SiteUserRepository repository;
	
	@Mock
	private PasswordEncoder encoder;
	
	@InjectMocks
	private AuthServiceImpl service;
	
	private SiteUser siteUser;
	
	private RegisterDto dto;
	
	private String result;
	
	@BeforeEach
	void init() {
		dto = new RegisterDto();
		dto.setEmailAddress("abc@gmail.com");
		dto.setPassword("1");
		dto.setPhoneNumber("123456789");
		
		siteUser = new SiteUser();
		siteUser.setEmailAddress("abc@gmail.com");
		siteUser.setPassword(result);
		siteUser.setPhoneNumber("123456789");
	}
	
	@Test
	void shouldRegister() {
		when(repository.save(any(SiteUser.class))).thenReturn(siteUser);
		when(encoder.encode(any(String.class))).thenReturn(result);
		service.register(dto);

		verify(encoder).encode(any(String.class));
		verify(repository).save(any(SiteUser.class));
	}
	
}
