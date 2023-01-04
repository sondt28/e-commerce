package com.son.ecommerce.common.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.son.ecommerce.common.utils.JwtHelper;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

	@Autowired
	private JwtHelper helper;
	
	@Autowired
	private UserDetailsService service;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = helper.getHeader(request);
		
		if (helper.validate(token)) {
			String emailAddress = helper.getEmail(token);
			UserDetails userDetails = service.loadUserByUsername(emailAddress);
			
			Authentication auth = 
				new UsernamePasswordAuthenticationToken(emailAddress, null, userDetails.getAuthorities());
		
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		
		filterChain.doFilter(request, response);
	}

}
