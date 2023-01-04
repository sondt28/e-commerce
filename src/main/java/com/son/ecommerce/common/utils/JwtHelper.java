package com.son.ecommerce.common.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtHelper {

	private final long EXP = 86400000;
	private final String KEY = "123456";
	private final String prefix = "Bearer ";
	
	public String generateToken(String emailAddress) {
		return Jwts.builder()
				.setIssuer(emailAddress)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + EXP))
				.signWith(SignatureAlgorithm.HS256, KEY)
				.compact();
	}
	
	public String getHeader(HttpServletRequest request) {
		String jwt = request.getHeader("Authorization");
		
		if (jwt == null)
			return null;
		
		return jwt.substring(prefix.length(), jwt.length());
	}

	public boolean validate(String token) {
		try {
			Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		
		return false;
	}

	public String getEmail(String token) {
		return Jwts.parser()
					.setSigningKey(KEY)
					.parseClaimsJws(token)
					.getBody()
					.getIssuer();
	}
}
