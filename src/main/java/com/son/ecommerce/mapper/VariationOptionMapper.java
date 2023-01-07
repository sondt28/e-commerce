package com.son.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.son.ecommerce.dto.VariationOptionDto;
import com.son.ecommerce.model.VariationOption;

@Mapper
public interface VariationOptionMapper {

	VariationOptionMapper INSTANCE = Mappers.getMapper(VariationOptionMapper.class);
	
	VariationOptionDto modelToDto(VariationOption model);
	VariationOption dtoToModel(VariationOptionDto dto);
}
