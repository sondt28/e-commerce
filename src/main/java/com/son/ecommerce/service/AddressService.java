package com.son.ecommerce.service;

import java.util.List;

import com.son.ecommerce.dto.AddressDto;
import com.son.ecommerce.model.Address;

public interface AddressService {

	List<AddressDto> findAllByUser();
	
	AddressDto findById(long id);
	
	void save(AddressDto address);
	
	void update(long id, Address address);
	
	void delete(long id);
}
