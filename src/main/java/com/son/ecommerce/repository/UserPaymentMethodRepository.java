package com.son.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.son.ecommerce.model.SiteUser;
import com.son.ecommerce.model.UserPaymentMethod;

@Repository
public interface UserPaymentMethodRepository extends JpaRepository<UserPaymentMethod, Long> {
	
	List<UserPaymentMethod> findBySiteUser(SiteUser siteUser);
}
