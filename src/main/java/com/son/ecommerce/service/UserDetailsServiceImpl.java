package com.son.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.son.ecommerce.common.exception.SiteUserException;
import com.son.ecommerce.model.SiteUser;
import com.son.ecommerce.repository.SiteUserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private SiteUserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String emailAddress) throws UsernameNotFoundException {
		SiteUser siteUser = repository.findByEmailAddress(emailAddress)
				.orElseThrow(() -> new SiteUserException("Site user not found!"));
		
		return new User(siteUser.getEmailAddress(), siteUser.getPassword(), getAuthorities(siteUser));
	}
	
	List<GrantedAuthority> getAuthorities(SiteUser siteUser) {
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(siteUser.getRole().name()));
		
		return authorities;
	}
}
