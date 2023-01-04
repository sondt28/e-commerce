package com.son.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.son.ecommerce.common.exception.AddressException;
import com.son.ecommerce.dto.AddressDto;
import com.son.ecommerce.mapper.AddressMapper;
import com.son.ecommerce.model.Address;
import com.son.ecommerce.model.AddressDefaultEnum;
import com.son.ecommerce.model.SiteUser;
import com.son.ecommerce.repository.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository repository;
	
	@Autowired
	private AuthService authService;
	
	@Override
	public List<AddressDto> findAllByUser() {
		SiteUser userCurrent = authService.findCurrentUser();
		List<Address> addresses = repository.findBySiteUser(userCurrent);
		
		List<AddressDto> dtos = addresses.stream()
						.map(t -> AddressMapper.INSTANCE.addressToAddressDto(t))
						.collect(Collectors.toList());
		
		return dtos;
	}

	@Override
	public void save(AddressDto dto) {
		SiteUser userCurrent = authService.findCurrentUser();
		
		Iterable<Address> addresses = repository.findAll();
		addresses.forEach(t -> t.setIsDefault(AddressDefaultEnum.N));
		repository.saveAll(addresses);
		
		Address address = AddressMapper.INSTANCE.dtoToModel(dto);
		address.setSiteUser(userCurrent);
		address.setIsDefault(AddressDefaultEnum.Y);
		
		repository.save(address);
	}

	@Override
	public void update(long id, Address address) {
		Address currentAddress = repository.findById(id)
				.orElseThrow(() -> new AddressException("Address not found!"));
		
		currentAddress.setCity(address.getCity());
		currentAddress.setDistrict(address.getDistrict());
		currentAddress.setSubDistrict(address.getSubDistrict());
		currentAddress.setAddressDetails(address.getAddressDetails());
		currentAddress.setIsDefault(address.getIsDefault());
		
		repository.save(currentAddress);
	}

	@Override
	public void delete(long id) {
		Address currentAddress = repository.findById(id)
				.orElseThrow(() -> new AddressException("Address not found!"));
		
		repository.delete(currentAddress);
	}

	@Override
	public AddressDto findById(long id) {
		Address address = repository.findById(id)
				.orElseThrow(() -> new AddressException("Address not found!"));
		
		AddressDto dto = AddressMapper.INSTANCE.addressToAddressDto(address);
		
		return dto;
	}
}
