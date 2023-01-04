package com.son.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.son.ecommerce.common.exception.SiteUserException;
import com.son.ecommerce.common.utils.JwtHelper;
import com.son.ecommerce.dto.LoginDto;
import com.son.ecommerce.dto.RegisterDto;
import com.son.ecommerce.mapper.SiteUserMapper;
import com.son.ecommerce.model.SiteUser;
import com.son.ecommerce.repository.SiteUserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private SiteUserRepository repository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private JwtHelper jwtHelper;
	
	@Override
	public String login(LoginDto dto) {
		
		SiteUser siteUser = repository.findByEmailAddress(dto.getEmailAddress())
				.orElseThrow(() -> new SiteUserException("Email not found!"));
	
		boolean decode = encoder.matches(dto.getPassword(), siteUser.getPassword());
		
		if (decode) {
			return jwtHelper.generateToken(siteUser.getEmailAddress());
		}
		
		return null;
	}

	@Override
	public void register(RegisterDto dto) {
		String passwordEncode = encoder.encode(dto.getPassword());
		dto.setPassword(passwordEncode);
		
		SiteUser user = SiteUserMapper.INSTANCE.registerToUser(dto);
		
		repository.save(user);
	}

	@Override
	public SiteUser findCurrentUser() {
		
		String email = (String) SecurityContextHolder
									.getContext()
									.getAuthentication()
									.getPrincipal();
		
		SiteUser siteUser = repository.findByEmailAddress(email)
							.orElseThrow(() -> new SiteUserException("User not found!"));
		
		return siteUser;
	}

}
