package com.son.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.son.ecommerce.model.Address;
import com.son.ecommerce.model.SiteUser;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

	List<Address> findBySiteUser(SiteUser siteUser);
}
