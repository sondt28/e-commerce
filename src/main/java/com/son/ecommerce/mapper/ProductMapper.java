package com.son.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.son.ecommerce.dto.ProductDto;
import com.son.ecommerce.model.Product;

@Mapper
public interface ProductMapper {

	ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
	
	ProductDto modelToDto(Product model);
	Product dtoToModel(ProductDto dto);
}
