package com.son.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.son.ecommerce.dto.PaymentMethodDto;
import com.son.ecommerce.model.UserPaymentMethod;

@Mapper
public interface UserPaymentMethodMapper {

	UserPaymentMethodMapper INSTANCE = Mappers.getMapper(UserPaymentMethodMapper.class);
	
	UserPaymentMethod dtoToModel(PaymentMethodDto dto);
	PaymentMethodDto modelToDto(UserPaymentMethod model);
}
