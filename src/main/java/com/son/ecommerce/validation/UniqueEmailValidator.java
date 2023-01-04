package com.son.ecommerce.validation;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.son.ecommerce.model.SiteUser;
import com.son.ecommerce.repository.SiteUserRepository;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	private SiteUserRepository repository;
	
	@Override
	public boolean isValid(String emailAddress, ConstraintValidatorContext context) {
		
		Optional<SiteUser> siteUserOpt = repository.findByEmailAddress(emailAddress);
		
		if (siteUserOpt.isPresent())
			return false;
		
		return true;
	}
}
