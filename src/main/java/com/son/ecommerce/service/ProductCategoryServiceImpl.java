package com.son.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.son.ecommerce.common.exception.ProductCategoryException;
import com.son.ecommerce.dto.ProductCategoryDto;
import com.son.ecommerce.mapper.ProductCategoryMapper;
import com.son.ecommerce.model.ProductCategory;
import com.son.ecommerce.repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryRepository repository;
	
	@Override
	public List<ProductCategory> findAll() {
		
		List<ProductCategory> categories = repository.findAll();
		
		return categories;
	}

	@Override
	public ProductCategoryDto save(ProductCategoryDto dto) {
		ProductCategory category = ProductCategoryMapper.INSTANCE.dtoToModel(dto);
		
		return ProductCategoryMapper.INSTANCE.modelToDto(repository.save(category));
	}

	@Override
	public ProductCategoryDto update(long id, ProductCategoryDto dto) {
		ProductCategory category = repository.findById(id)
				.orElseThrow(() -> new ProductCategoryException("category not found!"));
		
		category.setCategoryName(dto.getCategoryName());
		category.setParentCategory(dto.getParentCategory());
		category.setChildrenCategory(dto.getChildrenCategory());
		
		return ProductCategoryMapper.INSTANCE.modelToDto(repository.save(category));
	}

	@Override
	public ProductCategoryDto findById(long id) {
		ProductCategory category = repository.findById(id)
				.orElseThrow(() -> new ProductCategoryException("category not found!"));
		
		return ProductCategoryMapper.INSTANCE.modelToDto(category);
	}

	@Override
	public void deleteById(long id) {
		ProductCategory category = repository.findById(id)
				.orElseThrow(() -> new ProductCategoryException("category not found!"));
		
		repository.delete(category);
	}
}
