package com.son.ecommerce.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.son.ecommerce.common.exception.ProductException;
import com.son.ecommerce.dto.ProductDto;
import com.son.ecommerce.mapper.ProductMapper;
import com.son.ecommerce.model.Product;
import com.son.ecommerce.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Override
	public List<ProductDto> findAll() {
		List<Product> products = repository.findAll();
		List<ProductDto> dtos = products.stream()
							.map(t -> ProductMapper.INSTANCE.modelToDto(t))
							.collect(Collectors.toList());
		return dtos;
	}

	@Override
	public ProductDto save(ProductDto productDto) {
		Product product = ProductMapper.INSTANCE.dtoToModel(productDto);
		repository.save(product);
		
		ProductDto dto = ProductMapper.INSTANCE.modelToDto(product);
		return dto;
	}

	@Override
	public ProductDto findById(long id) {
		Product product = repository.findById(id)
				.orElseThrow(() -> new ProductException("Product not found."));
		
		ProductDto dto = ProductMapper.INSTANCE.modelToDto(product);
		
		return dto;
	}

	@Override
	public ProductDto updateById(long id, ProductDto dto) {
		Product product = repository.findById(id)
				.orElseThrow(() -> new ProductException("Product not found."));
		
		product.setDescription(dto.getDescription());
		product.setName(dto.getName());
		product.setProductImage(dto.getProductImage());
		
		ProductDto updateDto = ProductMapper.INSTANCE.modelToDto(repository.save(product));
		
		return updateDto;
	}

	@Override
	public void deleteById(long id) {
		Product product = repository.findById(id)
				.orElseThrow(() -> new ProductException("Product not found."));
		
		repository.delete(product);
	}
}
