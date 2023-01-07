package com.son.ecommerce.service;

import java.util.List;

import com.son.ecommerce.dto.ProductCategoryDto;
import com.son.ecommerce.model.ProductCategory;

public interface ProductCategoryService {
	List<ProductCategory> findAll();
	
	ProductCategoryDto save(ProductCategoryDto dto);
	
	ProductCategoryDto update(long id, ProductCategoryDto dto);

	ProductCategoryDto findById(long id);
	void deleteById(long id);
}
