package com.son.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.son.ecommerce.dto.VariationDto;
import com.son.ecommerce.model.Variation;

@Mapper
public interface VariationMapper {

	VariationMapper INSTANCE = Mappers.getMapper(VariationMapper.class);
	
	VariationDto modelToDto(Variation model);
	Variation dtoToModel(VariationDto dto);
}
