package com.son.ecommerce.service;

import java.util.List;

import com.son.ecommerce.dto.VariationOptionDto;

public interface VariationOptionService {
	List<VariationOptionDto> findAll();
	
	VariationOptionDto save(VariationOptionDto dto);
	
	VariationOptionDto update(long id, VariationOptionDto dto);
	
	VariationOptionDto findById(long id);
	
	void delete(long id);
}
