package com.son.ecommerce.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.son.ecommerce.model.SiteUser;

@Repository
public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {

	Optional<SiteUser> findByEmailAddress(String emailAddress);
}
