package com.son.ecommerce.service;

import com.son.ecommerce.dto.LoginDto;
import com.son.ecommerce.dto.RegisterDto;
import com.son.ecommerce.model.SiteUser;

public interface AuthService {
	String login(LoginDto dto);
	
	void register(RegisterDto dto);
	
	SiteUser findCurrentUser();
}
