package com.son.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.son.ecommerce.dto.AddressDto;
import com.son.ecommerce.model.Address;

@Mapper
public interface AddressMapper {

	AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
	
	AddressDto addressToAddressDto(Address model);
	
	Address dtoToModel(AddressDto dto);
}
