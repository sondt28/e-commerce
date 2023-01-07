package com.son.ecommerce.service;

import java.util.List;

import com.son.ecommerce.dto.ProductDto;

public interface ProductService {
	List<ProductDto> findAll();
	ProductDto save(ProductDto productDto);
	ProductDto findById(long id);
	ProductDto updateById(long id, ProductDto dto);
	void deleteById(long id);
}
