package com.son.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.son.ecommerce.dto.ProductCategoryDto;
import com.son.ecommerce.model.ProductCategory;

@Mapper
public interface ProductCategoryMapper {

	ProductCategoryMapper INSTANCE = Mappers.getMapper(ProductCategoryMapper.class);
	
	ProductCategory dtoToModel(ProductCategoryDto dto);
	ProductCategoryDto modelToDto(ProductCategory model);
}
